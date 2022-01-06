package com.aksonenko.spring.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.aksonenko.spring.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	List<Book> allBooks = null;
	int counter;

	@Override
	public List<Book> getAllBooks() {

		if (allBooks == null) {
			try {
				allBooks = getAllBooksFromDataSimulation();
				counter = allBooks.size();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return allBooks;
	}

	@Override
	public void addNewBook(Book book) {

		book.setId(++counter);
		allBooks.add(book);

	}

	@Override
	public void saveBook(Book book) {

		for (Book b : allBooks) {
			if (b.getId() == book.getId()) {
				b.setName(book.getName());
				b.setAuthor(book.getAuthor());
				b.setGenre(book.getGenre());
				b.setPrice(book.getPrice());
			}
		}

	}

	@Override
	public Book getBook(int id) {

		Book book = new Book();

		for (Book b : allBooks) {
			if (b.getId() == id) {
				book = b;
			}
		}

		return book;
	}

	@Override
	public void deleteBook(int id) {

		int index = 0;

		for (Book book : allBooks) {

			if (book.getId() == id) {
				allBooks.remove(index);
				return;
			}

			index++;
		}

	}

	public static List<Book> getAllBooksFromDataSimulation() {

		Book book1 = new Book(0, "Horus Rising", "Dan Abnett", "Sci-Fi", 500);
		Book book2 = new Book(1, "Mechanicum", "Graham McNeill", "Sci-Fi", 550);
		Book book3 = new Book(2, "Ruinstorm", "David Annandale", "Sci-Fi", 600);

		List<Book> allBooks = new ArrayList<>();
		allBooks.add(book1);
		allBooks.add(book2);
		allBooks.add(book3);

		return allBooks;
	}

}
