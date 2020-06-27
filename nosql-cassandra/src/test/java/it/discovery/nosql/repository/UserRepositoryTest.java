package it.discovery.nosql.repository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.datastax.oss.driver.api.core.CqlSession;

import it.discovery.nosql.model.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * TODO
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Autowired
    CqlSession session;

    User user;

    @Before
    public void setUp() {

        user = new User();
        user.setId(42L);
        user.setUsername("foobar");
        user.setFirstname("firstname");
        user.setLastname("lastname");
    }

    /**
     * Saving an object using the Cassandra Repository will create a persistent representation of the object in
     * Cassandra.
     */
    @Test
    public void findSavedUserById() {

        user = repository.save(user);

        assertThat(repository.findById(user.getId())).contains(user);
    }

    /**
     * Cassandra can be queries by using query methods annotated with {@link @Query}.
     */
    @Test
    public void findByAnnotatedQueryMethod() {

        repository.save(user);

        assertThat(repository.findUserByIdIn(1000)).isNull();
        assertThat(repository.findUserByIdIn(42)).isEqualTo(user);
    }

    /**
     * Spring Data Cassandra supports query derivation so annotating query methods with
     * {@link org.springframework.data.cassandra.repository.Query} is optional. Querying columns other than the primary
     * key requires a secondary index.
     */
    @Test
    public void findByDerivedQueryMethod() throws InterruptedException {

        session.execute("CREATE INDEX IF NOT EXISTS user_username ON users (uname);");
		/*
		  Cassandra secondary indexes are created in the background without the possibility to check
		  whether they are available or not. So we are forced to just wait. *sigh*
		 */
        Thread.sleep(1000);

        repository.save(user);

        assertThat(repository.findUserByUsername(user.getUsername())).isEqualTo(user);
    }

    /**
     * Spring Data Cassandra supports {@code LIKE} and {@code CONTAINS} query keywords to for SASI indexes.
     */
    @Test
    public void findByDerivedQueryMethodWithSASI() throws InterruptedException {

        session.execute("CREATE CUSTOM INDEX ON users (lname) USING 'org.apache.cassandra.index.sasi.SASIIndex';");
		/*
		  Cassandra secondary indexes are created in the background without the possibility to check
		  whether they are available or not. So we are forced to just wait. *sigh*
		 */
        Thread.sleep(1000);

        repository.save(user);

        List<User> users = repository.findUsersByLastnameStartsWith("last");
        assertThat(users.contains(user));
    }
}
