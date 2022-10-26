package com.example.demo.api.web;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.service.AdrService;

@RestController
public class AdrController {
	
	private AdrService adrService;
	
	public AdrController(AdrService adrService) {
		this.adrService = adrService;
	}
	
	@CrossOrigin(originPatterns = "*")
	@RequestMapping(value = "/v1/api001/adr.do", method = {RequestMethod.GET})
	public ResponseEntity<String> v1_api001_adr(Model model) throws IOException {
	
		return ResponseEntity.ok()
				.body(adrService.testAdr())
				;
	}
	
	
}
