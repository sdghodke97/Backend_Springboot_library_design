package com.gl.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.gl.library.model.FullName;
import com.gl.library.model.GreatLearning;
import com.gl.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

	@Override
	public GreatLearning get() {
		log.info("Inside Get() Method");
		GreatLearning greatlearning = new GreatLearning();
		greatlearning.setCourseName("Learn controllers and restcontroller annotations");
		greatlearning.setCourseType("Information Tech");
		greatlearning.setInstructorName(FullName.builder().firstName("Lone").lastName("Wolf").build());
//		greatlearning.setInstructorName("Shubhankar Dhananjay Ghodke");

		return greatlearning;
	}
	@Override
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("Inside customInfo() Method");
		GreatLearning greatlearning = new GreatLearning();
			greatlearning.setCourseName(courseName);
			greatlearning.setCourseType(courseType);
			greatlearning.setInstructorName(FullName.builder().firstName("Lone").lastName("Wolf").build());
		return greatlearning;
	}
}
