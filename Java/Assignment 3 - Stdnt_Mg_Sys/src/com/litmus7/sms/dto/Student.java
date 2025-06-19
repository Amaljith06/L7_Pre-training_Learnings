package com.litmus7.sms.dto;

import java.util.Scanner;

/**
 * This class represents a student with name, roll number and marks in 5
 * subjects
 * 
 */
public class Student {
	private String name;
	private int rollNo;
	private double marks[] = new double[5];

	/**
	 * Enum for student grades
	 */
	private enum Grade {
		A, B, C, D, F
	}

	/**
	 * This method takes input from user for students name, roll number and subject
	 * marks
	 */
	public void inputDetails() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter name: ");
		name = scan.nextLine();
		System.out.print("Enter roll number: ");
		rollNo = scan.nextInt();
		System.out.println("Enter marks for 5 subjects");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject" + (i + 1) + ": ");
			marks[i] = scan.nextDouble();
		}
	}

	/**
	 * This method calculates the total marks obtained by the student
	 * 
	 * @return total marks
	 */
	public double calculateTotal() {
		double total = 0;

		for (double mark : marks) {
			total += mark;
		}
		return total;
	}

	/**
	 * This method calculates the average marks of the student
	 * 
	 * @return average marks
	 */
	private double calculateAverage() {
		double avg;

		avg = calculateTotal() / 5;
		return avg;
	}

	/**
	 * This method determines the grade of the student based on average marks
	 * 
	 * @param <Grade>
	 * 
	 * @return grade as a string
	 */
	private Grade getGrades() {
		double avg = calculateAverage();

		if (avg >= 90) {
			return Grade.A;
		} else if (avg >= 75) {
			return Grade.B;
		} else if (avg >= 60) {
			return Grade.C;
		} else if (avg >= 50) {
			return Grade.D;
		} else {
			return Grade.F;
		}
	}

	/**
	 * This method prints the report card of the student
	 */
	public void printReportCard() {
		System.out.println("\n---Report Card---\n");
		System.out.printf("Name: %s%nRoll Number: %d%nTotal Marks: %.2f%nAverage Marks: %.2f%nGrade: %s%n", name,
				rollNo, calculateTotal(), calculateAverage(), getGrades());
	}
}
