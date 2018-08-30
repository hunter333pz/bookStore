package com.example.hunter333.bookStore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Hunter333
 *
 */
@RestController
public class TestController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hi";
	}
}