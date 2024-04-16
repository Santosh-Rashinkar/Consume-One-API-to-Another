package com.prowings.myapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface RestApiConsumeService {
	
	public ResponseEntity<List> getStds();
	

}