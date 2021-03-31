package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	@GetMapping("/hello")
	public String sayHello() {
		log.debug("Inside HelloController's sayHello Method");
		return "Hello World";
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		log.debug("Inside HelloController's sayHello Method");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		return (Country) context.getBean("us");

	}

	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries() {
		log.debug("Inside HelloController's sayHello Method");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		return (ArrayList<Country>) context.getBean("countryList");

	}
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		log.debug("Inside HelloController's getCountry Method");
		Country country = CountryService.getCountry(code);
		
		return country;
		
	}

}
