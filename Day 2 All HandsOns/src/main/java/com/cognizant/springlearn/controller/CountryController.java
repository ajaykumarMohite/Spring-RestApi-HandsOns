package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CountryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	@Autowired
	private CountryService countryService;

	@RequestMapping("/country")
	public Country getCountryIndia() {
		log.info("START");
		log.debug("Calling getCountry() with method 'GET'");
		log.info("END");
		return (Country) context.getBean("in");
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		log.info("START");
		log.debug("Calling getAllCountries() with method 'GET'");
		log.info("END");
		return (List<Country>) context.getBean("countryList");
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		log.info("START");
		log.debug("Calling getCountry() with method 'GET' and code=" + code);
		log.info("END");
		return countryService.getCountry(code);
	}

	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		log.debug("Start");
		Country countr = countryService.addCountry(country);
		return countr;
	}
}