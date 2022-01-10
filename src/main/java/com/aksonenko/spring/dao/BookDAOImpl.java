package com.aksonenko.spring.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.aksonenko.spring.entity.Author;
import com.aksonenko.spring.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	private List<Author> allAuthors = null;
	private List<Book> allBooks = null;
	private AtomicInteger authorCounter = new AtomicInteger();
	private AtomicInteger bookCounter = new AtomicInteger();

	@Override
	public List<Book> getAllBooks() {

		if (allBooks == null) {

			allBooks = getAllBooksFromDataSimulation();
			bookCounter.set(allBooks.size());

		}

		return allBooks;
	}
	
	@Override
	public List<Author> getAllAuthors() {

		if (allAuthors == null) {

			allAuthors = getAllAuthorsFromDataSimulation();
			authorCounter.set(allAuthors.size());

		}

		return allAuthors;
	}

	@Override
	public void addNewBook(Book book) {
		
		book.setId(bookCounter.incrementAndGet());
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
				System.out.println("book with id = " + book.getId() 
				+ " has been added");
				
				break;
			}
		}
		

	}
	
	@Override
	public Book getBook(int id) {

		Book book = new Book();

		for (Book b : allBooks) {
			if (b.getId() == id) {
				book = b;
				
				return book;
			}
		}

		return book;
	}
	
	@Override
	public void updateBook(Book book) {

		for (Book b : allBooks) {
			if (b.getId() == book.getId()) {
				b.setName(book.getName());
				b.setAuthor(book.getAuthor());
				b.setGenre(book.getGenre());
				b.setPrice(book.getPrice());
				System.out.println("book with id = " + book.getId() 
						+ " has been updated");
				
				break;
			}
		}

	}

	@Override
	public void deleteBook(int id) {
		
		int index = 0;

		for (Book book : allBooks) {

			if (book.getId() == id) {
				allBooks.remove(index);
				System.out.println("book with id = " + id 
						+ " has been deleted");
				
				break;
			}

			index++;
		}

	}

	public static List<Book> getAllBooksFromDataSimulation() {
		
		Book book1 = new Book(0, "Horus Rising", 0, "Sci-Fi", 500);
		Book book2 = new Book(1, "Mechanicum", 1, "Sci-Fi", 550);
		Book book3 = new Book(2, "Ruinstorm", 2, "Sci-Fi", 600);

		List<Book> allBooks = new CopyOnWriteArrayList<>();
		allBooks.add(book1);
		allBooks.add(book2);
		allBooks.add(book3);

		return allBooks;
	}
	
	public static List<Author> getAllAuthorsFromDataSimulation() {
		
		Author author1 = new Author(0,"Dan", "Abnett");
		Author author2 = new Author(1,"Graham", "McNeill");
		Author author3 = new Author(2,"David", "Annandale");

		List<Author> allAuthors = new CopyOnWriteArrayList<>();
		allAuthors.add(author1);
		allAuthors.add(author2);
		allAuthors.add(author3);

		return allAuthors;
	}

}
