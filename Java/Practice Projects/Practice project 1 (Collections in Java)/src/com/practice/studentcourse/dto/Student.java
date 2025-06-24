package com.practice.studentcourse.dto;

import java.util.HashMap;
import java.util.Map;

public class Student {
	private String studentId;
	private String name;
	private Map<Course, Integer> courseMarks = new HashMap<>();

	public Student(String studentId, String name) {
		this.studentId = studentId;
		this.name = name;

	}

	public void enrollInCourse(Course course, int marks) {
		courseMarks.put(course, marks);
	}

	public Map<Course, Integer> getCourseMarks() {
		return courseMarks;
	}

	public String getName() {
		return name;
	}

	public String getStudentId() {
		return studentId;
	}
}