package it.discovery.nosql.repository;

import it.discovery.nosql.BaseNeo4jTest;
import it.discovery.nosql.model.Book;
import it.discovery.nosql.model.Person;
import it.discovery.nosql.model.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookRepositoryTest extends BaseNeo4jTest {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	PersonRepository personRepository;

	@Test
	void findByAuthorName_returnsSingleBook() {
		Person author = new Person();
		author.setName("Gavin King");

		personRepository.save(author);
		Publisher publisher = new Publisher();
		publisher.setName("Packt");

		publisherRepository.save(publisher);

		Book book1 = new Book();
		book1.setNameEn("JPA");
		book1.setAuthor(author);
		book1.setPublisher(publisher);

		Book book2 = new Book();
		book2.setNameEn("Hibernate");
		book2.setAuthor(author);
		book2.setPublisher(publisher);

		bookRepository.saveAll(List.of(book1, book2));
	}

}
