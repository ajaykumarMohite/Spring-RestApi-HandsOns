package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Country {
	@NotNull
	@Size(min=2,max=2, message="Country code should be 2 characters")
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
