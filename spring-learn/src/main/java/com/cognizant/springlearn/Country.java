package com.cognizant.springlearn;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Country {
	private String code;
	private String name;

	public Country() {
		log.debug("Inside Country Constructor");
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
