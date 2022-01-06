package com.aksonenko.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aksonenko.spring.entity.Book;
import com.aksonenko.spring.service.BookService;

@Controller
public class MyController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/")
	public String showAllBooks(Model model) {

		List<Book> allBooks = bookService.getAllBooks();
		model.addAttribute("allBooks", allBooks);

		return "all-books";
	}

	@RequestMapping("/addNewBook")
	public String addNewBook(Model model) {

		Book book = new Book();
		model.addAttribute("book", book);
		bookService.addNewBook(book);

		return "book-info";

	}

	@RequestMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) {

		bookService.saveBook(book);

		return "redirect:/";

	}

	@RequestMapping("/updateInfo")
	public String updateBook(@RequestParam("bookId") int id, Model model) {

		Book book = bookService.getBook(id);
		model.addAttribute("book", book);

		return "book-info";

	}

	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") int id) {

		bookService.deleteBook(id);

		return "redirect:/";
	}

}
