package com.uday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/jsonplace")
	public ResponseEntity<Object[]> getObjects() {
		ResponseEntity<Object[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos",
				Object[].class);

		return response;

	}

	@GetMapping("/jsonplace2")
	public ResponseEntity<Object[]> getObjects2() {
		ResponseEntity<Object[]> response = null;
		try {
			response = restTemplate.getForEntity("https://jsonplaceholder.com/todos", Object[].class);
			if (response.getStatusCode().value() != 200) {
				System.out.println("resource not found");
			}

		} catch (Exception e) {
			if(e instanceof ResourceAccessException)
				System.out.println("resoure not found");
			else
				System.out.println("unknown exception");
		}
		return response;

	}

	@GetMapping("/jsonplace1")
	public ResponseEntity<Object[]> getObjects1() {
		ResponseEntity<Object[]> response = null;
		try {
			response = restTemplate.getForEntity("https://jholder.typicode.com/todos", Object[].class);

		} catch (ResourceAccessException e) {
			System.out.println("resoure not found");
		}
		return response;
	}
}
