package it.discovery.nosql.repository;

import it.discovery.nosql.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, String> {

    /**
     * Returns all the persons sorted by name
     *
     * @return
     */
    //List<Person> findByOrderByNameAsc();
}
