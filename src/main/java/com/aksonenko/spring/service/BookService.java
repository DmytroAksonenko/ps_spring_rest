package com.aksonenko.spring.service;

import java.util.List;

import com.aksonenko.spring.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();

	public void addNewBook(Book book);

	public void saveBook(Book book);

	public Book getBook(int id);

	public void deleteBook(int id);

}
