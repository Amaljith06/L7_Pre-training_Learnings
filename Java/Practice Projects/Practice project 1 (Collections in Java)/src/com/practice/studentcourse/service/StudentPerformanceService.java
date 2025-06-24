package com.practice.studentcourse.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.practice.studentcourse.dto.Course;
import com.practice.studentcourse.dto.Student;

public class StudentPerformanceService {

	private Map<String, Student> studentMap = new HashMap<>();
	private Map<String, Course> courseCatalog = new HashMap<>();

	public void loadCoursesFromFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					Course course = new Course(parts[0].trim(), parts[1].trim());
					courseCatalog.put(course.getCourseId(), course);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading course file: " + e.getMessage());
		}
	}

	public Map<String, Student> getStudentMap() {
		return studentMap;
	}

	public Map<String, Course> getCourseCatalog() {
		return courseCatalog;
	}

	public void addStudent(Student student) {
		studentMap.put(student.getStudentId(), student);
	}

	public void assignCourseToStudent(String studentId, String courseId, int marks) {
		Student student = studentMap.get(studentId);
		Course course = courseCatalog.get(courseId);
		if (student != null && course != null) {
			student.enrollInCourse(course, marks);
		} else {
			System.out.println("Invalid student ID or course ID.");
		}
	}

	public void printStudentReport(String studentId) {
		Student student = studentMap.get(studentId);
		if (student == null) {
			System.out.println("Student not found.");
			return;
		}
		System.out.println("Performance Report for " + student.getName());
		Map<Course, Integer> marksMap = student.getCourseMarks();
		for (Map.Entry<Course, Integer> entry : marksMap.entrySet()) {
			System.out.println(entry.getKey() + " => Marks: " + entry.getValue());
		}
	}

}
