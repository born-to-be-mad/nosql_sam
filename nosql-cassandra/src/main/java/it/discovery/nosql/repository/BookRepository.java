package it.discovery.nosql.repository;

import it.discovery.nosql.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BookRepository extends CassandraRepository<Book, String> {

    /**
     * Returns most popular books sorted by number of views
     *
     * @return
     */
    // @Query("SELECT bookId, count(*) as amount FROM hits GROUP BY bookId")
    // List<Book> findMostViewed();

    /**
     * Returns most popular books sorted by number of orders
     *
     * @return
     */
    //List<Book> findMostOrdered();
}
