package com.practice.studentcourse;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.practice.studentcourse.dto.Course;
import com.practice.studentcourse.dto.Student;
import com.practice.studentcourse.service.StudentPerformanceService;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentPerformanceService service = new StudentPerformanceService();
		// Load course data from file
		service.loadCoursesFromFile("courses.txt");
		// Print courses using normal loop
		System.out.println("Available Courses:");
		Map<String, Course> courseCatalog = service.getCourseCatalog();
		Set<String> courseIds = courseCatalog.keySet();
		for (String courseId : courseIds) {
			Course course = courseCatalog.get(courseId);
			System.out.println(course);
		}
		// Input students
		System.out.println("\nEnter number of students:");
		int studentCount = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < studentCount; i++) {
			System.out.println("\nEnter student ID:");
			String studentId = sc.nextLine();
			System.out.println("Enter student name:");
			String studentName = sc.nextLine();
			Student student = new Student(studentId, studentName);
			service.addStudent(student);
			System.out.println("How many courses for this student?");
			int courseCount = Integer.parseInt(sc.nextLine());
			for (int j = 0; j < courseCount; j++) {
				System.out.println("Enter course ID:");
				String courseId = sc.nextLine();
				if (!courseCatalog.containsKey(courseId)) {
					System.out.println("Invalid course ID. Skipping...");
					continue;
				}
				System.out.println("Enter marks:");
				int marks = Integer.parseInt(sc.nextLine());
				service.assignCourseToStudent(studentId, courseId, marks);

			}
		}
		// Print student reports
		Map<String, Student> studentMap = service.getStudentMap();
		System.out.println("\nSTUDENT REPORTS:");
		for (String studentId : studentMap.keySet()) {
			service.printStudentReport(studentId);
			System.out.println("-----------------------------------");
		}
		sc.close();
	}
}