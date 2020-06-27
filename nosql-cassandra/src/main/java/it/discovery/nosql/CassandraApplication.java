package it.discovery.nosql;

import it.discovery.nosql.repository.BookRepository;
import it.discovery.nosql.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.EnableCassandraAuditing;

@SpringBootApplication
@EnableCassandraAuditing
public class CassandraApplication {

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(CassandraApplication.class, args);
    }
}
