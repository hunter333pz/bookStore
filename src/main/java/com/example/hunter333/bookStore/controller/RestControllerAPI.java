package com.example.hunter333.bookStore.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hunter333.bookStore.model.Author;
import com.example.hunter333.bookStore.model.Book;
import com.example.hunter333.bookStore.model.Publisher;
import com.example.hunter333.bookStore.repository.AuthorRepository;
import com.example.hunter333.bookStore.repository.BookRepository;
import com.example.hunter333.bookStore.repository.PublisherRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Hunter333
 *
 */
@RestController
public class RestControllerAPI {
	private BookRepository bookrepository;
	private AuthorRepository authorRepository;
	private PublisherRepository publisherRepository;
	Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	public RestControllerAPI(BookRepository bookrepository, AuthorRepository authorRepository,
			PublisherRepository publisherRepository) {
		super();
		this.bookrepository = bookrepository;
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
	}

	@RequestMapping("/hello")
	public String sayHello() {

		return "HeLLo";
	}

	@RequestMapping("/getUrls")
	public String getUrls() {
		List<String> urls = new ArrayList<String>();

		Method[] methods = this.getClass().getMethods();

		for (Method method : methods) {
			RequestMapping reqMappingAnnotatiton = method.getAnnotation(RequestMapping.class);
			urls.addAll(getMappingPaths(reqMappingAnnotatiton));
		}
		return new Gson().toJson(urls);
	}

	private List<String> getMappingPaths(RequestMapping requestMapping) {
		List<String> paths = new ArrayList<String>();
		if (requestMapping != null) {
			for (String path : requestMapping.value()) {
				paths.add(path);
			}
		}
		return paths;
	}

	@RequestMapping("/getBooks")
	public String getBooks() {
		ArrayList<Book> books = (ArrayList<Book>) bookrepository.findAll();
		return gson.toJson(books);
	}

	@RequestMapping("/getAuthors")
	public String getAuthors() {
		List<Author> authors = (List<Author>) authorRepository.findAll();
		return gson.toJson(authors);
	}

	public String getPublishers() {
		List<Publisher> publishers = (List<Publisher>) publisherRepository.findAll();
		return gson.toJson(publishers);
	}
}