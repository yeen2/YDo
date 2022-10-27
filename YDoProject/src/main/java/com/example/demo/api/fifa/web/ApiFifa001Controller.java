package com.example.demo.api.fifa.web;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.fifa.service.ApiFifa001Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ApiFifa001Controller {

	private ApiFifa001Service apiFifa001Service;
	
	public ApiFifa001Controller(ApiFifa001Service apiFifa001Service) {
		this.apiFifa001Service = apiFifa001Service;
	}
	
	@CrossOrigin(originPatterns = "*")
	@RequestMapping(value = "/v1/api/fifa/001.do", method = {RequestMethod.GET})
	public ResponseEntity<String> v1_api_fifa_001(Model model) throws IOException {
		
		return ResponseEntity.ok()
				.body(apiFifa001Service.allMatch());
	}
	
	@CrossOrigin(originPatterns = "*")
	@RequestMapping(value = "/v1/api/fifa/002.do", method = {RequestMethod.GET})
	public ResponseEntity<String> v1_api_fifa_002(@RequestParam(name = "matchId") String matchId, Model model) throws IOException {
		log.debug("matchId: {}", matchId);
		
		return ResponseEntity.ok()
				.body(apiFifa001Service.getMatch(matchId));
	}
}
