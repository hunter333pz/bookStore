package com.example.hunter333.bookStore.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hunter333.bookStore.model.Author;

/**
 * 
 * @author Hunter333
 *
 */

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
