package it.discovery.nosql;

import it.discovery.nosql.repository.BookRepository;
import it.discovery.nosql.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.annotation.EnableNeo4jAuditing;

@SpringBootApplication
@EnableNeo4jAuditing
public class Neo4jApplication {

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }
}
