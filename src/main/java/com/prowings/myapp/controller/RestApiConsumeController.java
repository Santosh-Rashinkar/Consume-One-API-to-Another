package com.prowings.myapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.myapp.config.MyWebConfig;
import com.prowings.myapp.model.Student;
import com.prowings.myapp.service.RestApiConsumeService;

@RestController
@RequestMapping("/consumeApi")
public class RestApiConsumeController {

	@Autowired
	RestApiConsumeService service;
	
	@Autowired
	MyWebConfig config;
	
	
	@GetMapping("/getStudents")
	public ResponseEntity<List> getStudentDataFromRestApi()
	{
		System.out.println(">>> Received request to fetch Std detail from REST API!!");
		
//		System.out.println("url from configuration is : "+config.getUrl());
//		System.out.println("uname from configuration is : "+config.getUname());
//		System.out.println("pwd from configuration is : "+config.getPwd());
		return service.getStds();	
	}
	
	@PostMapping("/createStudent")
	public ResponseEntity<String> createStudentDataFromRestApi(@RequestBody Student std)
	{
		System.out.println(">>> Received request to create Std Via REST API!!");
		
		return service.createStd(std);	
	}

}
