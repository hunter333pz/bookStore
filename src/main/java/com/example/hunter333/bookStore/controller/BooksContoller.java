package com.example.hunter333.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hunter333.bookStore.repository.BookRepository;

/**
 * 
 * @author Hunter333
 *
 */
@Controller
public class BooksContoller {
	private BookRepository bookRepository;

	public BooksContoller(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}
}
