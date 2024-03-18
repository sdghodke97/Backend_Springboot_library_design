package com.gl.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.model.GreatLearning;
import com.gl.library.service.ExampleService;

//@Controller     to avoid boiler plate code we can use restcontroller annotation
@RestController
public class ExampleController {
	
	
	@Autowired
	ExampleService exampleService;

	@GetMapping("/info")
//	@ResponseBody    consider this as a boilerplate code
	public GreatLearning get() {
		
		return exampleService.get();
	}

	@PostMapping("customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		
		return exampleService.customInfo(courseName, courseType, firstName, lastName);
	}
}
