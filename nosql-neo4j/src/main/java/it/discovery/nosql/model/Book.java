package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Book in a library
 */
@Getter
@Setter
@NodeEntity
public class Book extends BaseEntity {
	private String nameEn;

	private String nameRu;

	private String nameUk;

	private Complexity complexity;

	@Relationship("WRITTEN_BY")
	private Person author;

	@Relationship("PUBLISHED_BY")
	private Publisher publisher;

	/**
	 * Publishing year
	 */
	private int year;

	/**
	 * Total number of pages
	 */
	private int pages;

	private List<Review> reviews;

	public void addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(review);
		review.setBook(this);
	}
}
