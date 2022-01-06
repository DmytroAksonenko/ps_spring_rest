package com.aksonenko.spring.dao;

import java.util.List;

import com.aksonenko.spring.entity.Book;

public interface BookDAO {

	public List<Book> getAllBooks();

	public void addNewBook(Book book);

	public void saveBook(Book book);

	public Book getBook(int id);

	public void deleteBook(int id);

}
