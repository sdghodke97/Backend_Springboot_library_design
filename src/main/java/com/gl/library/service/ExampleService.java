package com.gl.library.service;

import com.gl.library.model.GreatLearning;

public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName);

}