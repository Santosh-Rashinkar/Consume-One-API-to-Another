package com.prowings.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.myapp.model.Student;

@Service
public class RestApiConsumeServiceImpl implements RestApiConsumeService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	Environment environment;


	@Override
	public ResponseEntity<List> getStds() {

		System.out.println(">>>> student service :: getStd() started!!");
		// call to rest api
		String uri = environment.getProperty("url");

		ResponseEntity<List> fetchedStd = restTemplate.getForEntity(uri, List.class);

		System.out.println(">>> received Std from REST Api : ");
		System.out.println(">>> Response Body : " + fetchedStd.getBody());
		System.out.println(">>> Response Status : " + fetchedStd.getStatusCodeValue());

		return fetchedStd;
	}

	@Override
	public ResponseEntity<String> createStd(Student std) {
		String uri = environment.getProperty("url");
		System.out.println("calling saveStudent resource of REST api...");

//		ResponseEntity<String> response = restTemplate.postForEntity(uri, std, String.class);
        String response =restTemplate.postForObject(uri, std, String.class);
//		return response;
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	private boolean validStudent(Student std) {

		if (std.getName().length() >= 4)
			return true;

		else
			return false;
	}

}