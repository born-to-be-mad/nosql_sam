package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Book publisher
 */
@Getter
@Setter
@NodeEntity
public class Publisher extends BaseEntity {
	private String name;

	@Relationship("PUBLISHED")
	private List<Book> books;

	private Contact contact;
}
