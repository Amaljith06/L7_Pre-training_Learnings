package com.litmus7.sms;

import java.util.Scanner;

import com.litmus7.sms.dto.Student;

/**
 * This class represents the main application to manage and display student
 * records
 */
public class StudentApp {
	/**
	 * The main method
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int n;
		n = scan.nextInt();
		Student students[] = new Student[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter details of student " + (i + 1));
			students[i] = new Student();
			students[i].inputDetails();
		}
		for (int i = 0; i < n; i++) {
			students[i].printReportCard();
		}

	}
}
