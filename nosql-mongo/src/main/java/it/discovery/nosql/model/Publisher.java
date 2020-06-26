package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Book publisher
 */
@Getter
@Setter
@Document(collection = "publishers")
@ToString
public class Publisher extends BaseEntity {
	private String name;

	private List<Integer> books;

	private Contact contact;
}
