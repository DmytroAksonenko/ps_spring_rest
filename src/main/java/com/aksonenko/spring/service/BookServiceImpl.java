package com.aksonenko.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aksonenko.spring.dao.BookDAO;
import com.aksonenko.spring.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	@Override
	public void addNewBook(Book book) {
		bookDAO.addNewBook(book);

	}

	@Override
	public void saveBook(Book book) {
		bookDAO.saveBook(book);

	}

	@Override
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}

	@Override
	public void deleteBook(int id) {
		bookDAO.deleteBook(id);

	}

}
