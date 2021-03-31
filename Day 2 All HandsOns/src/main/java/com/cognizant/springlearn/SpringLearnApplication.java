package com.cognizant.springlearn;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class SpringLearnApplication {


	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}

	public static void displayDate() throws ParseException {

		log.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("31/12/2018");
		log.debug(date.toString());
		log.info("END");
	}

	public static void displayCountry() {

		log.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		log.debug("Country : {}", country);
		log.debug("Country : {}", anotherCountry);
		log.info("END");
	}

	public static void displayCountries() {

		log.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		log.debug("Country : {}", countries);
		log.info("END");
	}

}