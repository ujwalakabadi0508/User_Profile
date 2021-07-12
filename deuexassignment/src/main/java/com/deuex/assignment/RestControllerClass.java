package com.deuex.assignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {

	@RequestMapping(value = "/value" , method = RequestMethod.GET)
	public int voiddd() {
		return 2;
	}
}
