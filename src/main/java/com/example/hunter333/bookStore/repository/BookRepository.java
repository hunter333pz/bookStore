package com.example.hunter333.bookStore.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hunter333.bookStore.model.Book;

/**
 * 
 * @author Hunter333
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
