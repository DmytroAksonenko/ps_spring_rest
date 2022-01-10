package com.aksonenko.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aksonenko.spring.entity.Author;
import com.aksonenko.spring.entity.Book;
import com.aksonenko.spring.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String showAllBooks(Model model) {
		List<Book> allBooks = bookService.getAllBooks();
		List<Author> allAuthors = bookService.getAllAuthors();
		model.addAttribute("allBooks", allBooks);
		model.addAttribute("allAuthors", allAuthors);

		return "all-books";
	}

//	Book creation page
	@RequestMapping("/addNewBook")
	public String addNewBook(Model model) {

		Book book = new Book();
		model.addAttribute("book", book);
		bookService.addNewBook(book);

		return "new-book";

	}

	@PostMapping("/saveBook")
	public synchronized String saveBook(@ModelAttribute("book") Book book) {

		bookService.saveBook(book);

		return "redirect:/";

	}
	
//	Book update page 
	@RequestMapping("/updateInfo")
	public String getBook(@RequestParam("bookId") int id, Model model) {

		Book book = bookService.getBook(id);
		model.addAttribute("book", book);

		return "book-info";

	}
	
	@PutMapping("/updateBook")
	public synchronized String updateBook(@ModelAttribute("book") Book book) {

		bookService.updateBook(book);

		return "redirect:/";

	}

	@DeleteMapping("/deleteBook")
	public synchronized String deleteBook(@RequestParam("book.id") int id) {

		bookService.deleteBook(id);

		return "redirect:/";
	}

}
