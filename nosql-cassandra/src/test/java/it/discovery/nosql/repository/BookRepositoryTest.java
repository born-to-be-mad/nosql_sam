package it.discovery.nosql.repository;

import it.discovery.nosql.BaseCassandraTest;
import it.discovery.nosql.model.Book;
import it.discovery.nosql.model.Hit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookRepositoryTest extends BaseCassandraTest {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	HitRepository hitRepository;

	@Test
	void findMostViewed_returnsOrderByHitCount() {
		Book book1 = new Book();
		book1.setNameEn("JPA");

		Book book2 = new Book();
		book2.setNameEn("Hibernate");
		bookRepository.saveAll(List.of(book1, book2));

		Hit hit1 = new Hit();
		hit1.setBrowser("Chrome");
		hit1.setBookId(book1.getId());

		Hit hit2 = new Hit();
		hit2.setBrowser("Chrome");
		hit2.setBookId(book1.getId());

		Hit hit3 = new Hit();
		hit3.setBrowser("Chrome");
		hit3.setBookId(book2.getId());

		hitRepository.saveAll(List.of(hit1, hit2, hit3));
	}

}
