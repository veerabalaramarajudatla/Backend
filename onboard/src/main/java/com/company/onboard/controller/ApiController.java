package com.company.onboard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class ApiController {
	@GetMapping("/get")
	public String getHello() {
	   return "Achala";
	}
}
