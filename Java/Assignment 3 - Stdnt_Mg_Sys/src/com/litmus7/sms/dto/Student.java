package com.litmus7.sms.dto;

import java.util.Scanner;

public class Student {
	private String name;
	private int rollNo;
	private double marks[] = new double[5];

	public void inputDetails() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		name = scan.nextLine();
		System.out.print("Enter roll number: ");
		rollNo = scan.nextInt();
		System.out.println("Enter marks for 5 subjects");
		for(int i=0; i<5; i++) {
			System.out.print("Subject" + (i+1) + ": ");
			marks[i] = scan.nextDouble();
		}
	}
	public double calculateTotal() {
		double total = 0;
		
		for(double mark : marks) {
			total += mark;
		}
		return total;
	}
	private double calculateAverage() {
		double avg;
		
		avg = calculateTotal() / 5;
		return avg;
	}
	private String getGrades() {
		double avg = calculateAverage();
		
		if(avg >= 90) { 
			return "A";
		} else if(avg >= 75) {
			return "B";
		} else if(avg >= 60) {
			return "C";
		} else if(avg >= 50) {
			return "D";
		} else {
			return "F";
		}
	}
	public void printReportCard() {
		System.out.println("\n---Report Card---\n");
		System.out.printf("Name: %s%nRoll Number: %d%nTotal Marks: %.2f%nAverage Marks: %.2f%nGrade: %s%n",name, rollNo, calculateTotal(), calculateAverage(), getGrades());
	}
}
