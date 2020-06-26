package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Book in a library
 */
@Getter
@Setter
@Document(collection = "books")
@ToString
public class Book extends BaseEntity {
	// Attribute pattern: we have to query/sort documents that have similar subset of fields
	private List<Translation> names;

	private Complexity complexity;

	private PersonInfo person;

	private int publisherId;

	// Document version pattern
	//private List<Publisher> previousPublishers;

	/**
	 * Publishing year
	 */
	private int year;

	/**
	 * Total number of pages
	 */
	private int pages;

	//private Review latestReview;

	private List<Review> reviews;

	// Computed pattern: recalculate on AddReview o
	@Getter
	private double rating;

	public void addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(review);

		rating = reviews.parallelStream()
				   	    .collect(Collectors.summarizingDouble(Review::getRate))
						.getAverage();

	}
}
