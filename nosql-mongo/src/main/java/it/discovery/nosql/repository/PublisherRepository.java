package it.discovery.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.discovery.nosql.model.Publisher;

public interface PublisherRepository extends MongoRepository<Publisher, Integer> {

}
