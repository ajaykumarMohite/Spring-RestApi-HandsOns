package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringLearnApplication {

	public static void displayDate() {
		log.debug("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date parse = format.parse("31/12/2018");
			log.debug("", parse);
			System.out.println(parse);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		log.debug("End");
	}

	public static void displayCountry() {
		log.debug("displayCountry method statted");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		log.debug("Country : {}", country);

		Country anotherCountry = context.getBean("country", Country.class);
		log.debug("displayCountry method ended");

	}

	public static void displayCountries() {
		log.debug("displayCountries Function START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> bean = (ArrayList) context.getBean("countryList");
		log.debug("{}", bean);
		log.debug("displayCountries function ended");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		// Calling dislpayDate function
			displayDate();

		// Calling displayCountry function
			displayCountry();
		
		// calling DisplayCountries function
		displayCountries();
	}

}
