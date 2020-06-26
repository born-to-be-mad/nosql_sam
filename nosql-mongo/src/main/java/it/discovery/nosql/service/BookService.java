package it.discovery.nosql.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.discovery.nosql.model.Book;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {
	//private final BookRepository bookRepository;
	//private final MongoTemplate mongoTemplate;
	private final MongoOperations mongoTemplate; //low coupling


	public List<Book> findByName(String name) {
		//return bookRepository.findByName(name);
		return mongoTemplate.find(
				new Query(Criteria.where("names.name").is(name)),
				Book.class);
	}

	public void saveBook(Book book) {
		//bookRepository.save(book);
		mongoTemplate.save(book);
	}
}
