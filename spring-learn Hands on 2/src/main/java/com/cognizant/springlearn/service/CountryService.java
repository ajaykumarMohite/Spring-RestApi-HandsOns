package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

public class CountryService {

	public static Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		ArrayList<Country> list = (ArrayList<Country>) context.getBean("countryList");
		for (Country country : list) {
			if(country.getCode().equalsIgnoreCase(code)) {
				return country;
			}
			
		}
		throw new CountryNotFoundException();
	}
}
