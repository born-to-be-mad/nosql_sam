package it.discovery.nosql.repository;

import it.discovery.nosql.model.Hit;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface HitRepository extends CassandraRepository<Hit, String> {
}
