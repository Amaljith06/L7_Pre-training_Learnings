package com.litmus7.sms;

import java.util.Scanner;

import com.litmus7.sms.dto.Student;

public class StudentApp {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int n;
		n = scan.nextInt();
		Student s[] = new Student[n];
		for(int i=0; i<n; i++) {
			System.out.println("Enter details of student " + (i+1));
			s[i] = new Student();
			s[i].inputDetails();
		}
		for(int i=0; i<n; i++) {
			s[i].printReportCard();
		}
		
	}
}
