package com.example.demo.api.web;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.service.Api001Service;

@RestController
public class Api001Controller {

	private Api001Service api001Service;
	
	public Api001Controller(Api001Service api001Service) {
		this.api001Service = api001Service;
	}
	
	@CrossOrigin(originPatterns = "*")
	@RequestMapping(value = "/v1/api001/001.do", method = {RequestMethod.GET})
	public ResponseEntity<String> v1_api001_001(Model model) throws IOException {
	
		return ResponseEntity.ok()
				.body(api001Service.test())
				;
	}
}
