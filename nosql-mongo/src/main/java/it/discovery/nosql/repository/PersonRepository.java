package it.discovery.nosql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.discovery.nosql.model.Person;

public interface PersonRepository  extends MongoRepository<Person, Integer> {

	/**
	 * Returns all the persons sorted by name
	 *
	 * @return
	 */
	List<Person> findByOrderByNameAsc();
}
