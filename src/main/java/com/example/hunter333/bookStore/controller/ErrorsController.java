package com.example.hunter333.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author ivaylo.dimitrov
 *
 */
@Controller
public class ErrorsController {
	@RequestMapping("/errors")
	public String error() {
		return "Internal server errror";
	}

}
