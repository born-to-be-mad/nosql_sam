package it.discovery.nosql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import it.discovery.nosql.model.Book;


public interface BookRepository extends MongoRepository<Book, String> {

	Book save(Book book);

	//@Query("FROM Book b join b.names tr WHERE tr.name = ?0")
	//List<Book> findByName(String name, String locale);

	//@Query("{name: ?0}")
	//List<Book> findByName(String name);

	@Query("FROM Book b join b.reviews r WHERE r.id is not null")
	List<Book> findWithReviews();

	//List<Book> findByPagesGreaterThan(int pages);

	//List<Book> findAllByAuthor_Name(String name);

	@Query("SELECT sum(b.pages) FROM Book b")
	int findTotalPages();

}
