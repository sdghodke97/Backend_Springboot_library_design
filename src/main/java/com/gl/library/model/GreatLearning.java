package com.gl.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {

	private String courseName;
	private String courseType;
//	private String InstructorName;
	private FullName InstructorName;
	
	public GreatLearning (String courseName) {
		this.courseName = courseName;
	}
	public GreatLearning(String courseName,String courseType) {
		this.courseName = courseName;
		this.courseType = courseType;
	}

	// no need of the following lines while using AllArgsConstructor annotation.
//	public GreatLearning(String courseName, String courseType, String instructorName) {
//		super();
//		this.courseName = courseName;
//		this.courseType = courseType;
//		InstructorName = instructorName;
//	}

//	@Override
//	public String toString() {
//		return "GreatLearning [courseName=" + courseName + ", courseType=" + courseType + ", InstructorName="
//				+ InstructorName + "]";
//	}

}
