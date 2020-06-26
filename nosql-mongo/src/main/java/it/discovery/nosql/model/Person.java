package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Person who can write books, for example
 *
 * @author admin
 */
@Getter
@Setter
@Document(collection = "persons")
@ToString
public class Person extends BaseEntity {
	private String name;

	/**
	 * Books that person has written
	 */
	private List<String> books;

	private Contact contact;
}
