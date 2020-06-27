package it.discovery.nosql.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.discovery.nosql.model.User;

/**
 * TODO
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * from users where user_id in(?0)")
    User findUserByIdIn(long id);

    User findUserByUsername(String username);

    List<User> findUsersByLastnameStartsWith(String lastnamePrefix);
}
