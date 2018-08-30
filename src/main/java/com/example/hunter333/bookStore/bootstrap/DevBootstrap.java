package com.example.hunter333.bookStore.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.hunter333.bookStore.model.Author;
import com.example.hunter333.bookStore.model.Book;
import com.example.hunter333.bookStore.model.Publisher;
import com.example.hunter333.bookStore.repository.AuthorRepository;
import com.example.hunter333.bookStore.repository.BookRepository;
import com.example.hunter333.bookStore.repository.PublisherRepository;

/****

@author Hunter333
 *
 */
 @Component
 public class DevBootstrap implements
 ApplicationListener<ContextRefreshedEvent> {
 private AuthorRepository authorRepository;
 private BookRepository bookRepository;
 private PublisherRepository publisherRepository;

 public DevBootstrap(AuthorRepository authorRepository, BookRepository
 bookRepository,
 PublisherRepository publisherRepository) {
 super();
 this.authorRepository = authorRepository;
 this.bookRepository = bookRepository;
 this.publisherRepository = publisherRepository;
 }

 @Override
 public void onApplicationEvent(ContextRefreshedEvent event) {
 initData();
 }

 private void initData() {
 Author eric = new Author("Eric", "Evans");
 Publisher harperColins = new Publisher("Harper Colins");
 Book domeinDrivenDesing = new Book("Domain Driven Design", "1234",
 harperColins);
 eric.getBooks().add(domeinDrivenDesing);
 domeinDrivenDesing.getAuthors().add(eric);

 authorRepository.save(eric);
 bookRepository.save(domeinDrivenDesing);
 publisherRepository.save(harperColins);

 Author rod = new Author("Rod", "Johnson");
 Publisher worx = new Publisher("Worx");
 Book noEJB = new Book("J2EE development withount EJB", "23444", worx);
 rod.getBooks().add(noEJB);
 noEJB.getAuthors().add(rod);

 authorRepository.save(rod);
 bookRepository.save(noEJB);
 publisherRepository.save(worx);
 }
 }
