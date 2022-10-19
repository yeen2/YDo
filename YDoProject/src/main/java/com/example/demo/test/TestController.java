package com.example.demo.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public ResponseEntity test1() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
