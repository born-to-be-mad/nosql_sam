package it.discovery.nosql.repository;

import it.discovery.nosql.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;

	@Test
	void findMostViewed_returnsOrderByHitCount() {
		Book book1 = new Book();
		book1.setNameEn("JPA");

		Book book2 = new Book();
		book2.setNameEn("Hibernate");

	}

}
