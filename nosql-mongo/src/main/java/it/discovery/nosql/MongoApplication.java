package it.discovery.nosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import it.discovery.nosql.repository.BookRepository;
import it.discovery.nosql.repository.PersonRepository;
import it.discovery.nosql.repository.PublisherRepository;

@SpringBootApplication
@EnableMongoAuditing
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("### Amount of books ###:%s\n", bookRepository.count());
        bookRepository.findAll().forEach(System.out::println);

        System.out.println("### Amount of persons ###:" + personRepository.count());
        personRepository.findAll().forEach(System.out::println);

        System.out.println("### Amount of publishers ###:" + publisherRepository.count());
        publisherRepository.findAll().forEach(System.out::println);
    }
}
