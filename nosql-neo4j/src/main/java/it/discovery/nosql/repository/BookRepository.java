package it.discovery.nosql.repository;

import it.discovery.nosql.model.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface BookRepository extends Neo4jRepository<Book, String> {

	/**
	 * Returns all the books with exact name and
	 * specified locale
	 *
	 * @param name
	 * @param locale
	 * @return
	 */
	//List<Book> findByName(String name, String locale);

	/**
	 * Returns all the books with exact name irregardless of locale
	 *
	 * @param name
	 * @return
	 */
	//List<Book> findByName(String name);

	/**
	 * Returns all the books of the specified author
	 * ignore them
	 *
	 * @param name
	 * @return
	 */
	List<Book> findAllByAuthor_Name(String name);

}
