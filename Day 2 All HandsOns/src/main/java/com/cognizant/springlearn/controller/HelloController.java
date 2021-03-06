package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		log.info("START");
		log.debug("Calling sayHello() with method 'GET'");
		log.info("END");
		return "Hello World!!";
	}
}