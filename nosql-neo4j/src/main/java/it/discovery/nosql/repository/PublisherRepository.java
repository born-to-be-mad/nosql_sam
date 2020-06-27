package it.discovery.nosql.repository;

import it.discovery.nosql.model.Publisher;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PublisherRepository extends Neo4jRepository<Publisher, String> {

}
