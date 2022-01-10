package com.aksonenko.spring.dao;

import java.util.List;

import com.aksonenko.spring.entity.Author;
import com.aksonenko.spring.entity.Book;

public interface BookDAO {

	List<Book> getAllBooks();
	
	List<Author> getAllAuthors();

	void addNewBook(Book book);

	void saveBook(Book book);
	
	void updateBook(Book book);

	Book getBook(int id);

	void deleteBook(int id);

}
