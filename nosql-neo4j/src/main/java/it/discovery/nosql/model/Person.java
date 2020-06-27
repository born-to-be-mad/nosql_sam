package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Person who can write books, for example
 *
 * @author admin
 */
@Getter
@Setter
@NodeEntity
public class Person extends BaseEntity {
	private String name;

	/**
	 * Books that person has written
	 */
	@Relationship("WROTE")
	private List<Book> books;

	private Contact contact;

}
