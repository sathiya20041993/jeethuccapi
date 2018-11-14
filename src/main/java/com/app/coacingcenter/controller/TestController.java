package com.app.coacingcenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/welocomemessage", method = RequestMethod.GET)
	public String welcome() {

		return "Hello World";
	}

}
