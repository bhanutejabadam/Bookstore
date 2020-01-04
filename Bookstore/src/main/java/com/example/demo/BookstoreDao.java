package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookstoreDao {
	@Autowired
	private Bookrepo repo;

	public void insert(Book book) {
		repo.save(book);	
	}
	
	public Iterable<Book> show() {
		Iterable<Book> it=repo.findAll();
		return it;
	}

	public Optional<Book> search(int id) {
	Optional<Book> book=repo.findById(id);
		return book;
		
		
	}

}
