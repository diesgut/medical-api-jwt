package com.diesgut.medical.apijwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiControllr {

	@GetMapping("/hola_jwt")
	public ResponseEntity<String> hola() {
		return new ResponseEntity<String>("hola", HttpStatus.OK);
	}
	
}
