package com.litmus7.retaildiscount.ui;

import java.util.Scanner;

import com.litmus7.retaildiscount.model.Discountable;
import com.litmus7.retaildiscount.model.PremiumCustomer;
import com.litmus7.retaildiscount.model.RegularCustomer;
import com.litmus7.retaildiscount.model.WholesaleCustomer;

/**
 * A console-based retail discount application.
 * 
 */
public class RetailStoreApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Discountable discount = null;

		while (discount == null) {
			System.out.println("Enter customer type (1- Regular, 2- Premium, 3- Wholesale): ");
			int customerType = scan.nextInt();

			switch (customerType) {
			case 1:
				discount = new RegularCustomer();
				break;
			case 2:
				discount = new PremiumCustomer();
				break;
			case 3:
				discount = new WholesaleCustomer();
				break;
			default:
				System.out.println("Invalid input");
			}
		}

		System.out.println("Enter total purchase amount: ");
		double totalAmount = scan.nextDouble();

		displayFinalAmount(totalAmount, discount);

		scan.close();
	}

	/**
	 * Calculates and displays the final payable amount after applying the discount.
	 *
	 * @param totalAmount the original total amount entered by the user
	 * @param discount
	 */
	private static void displayFinalAmount(double totalAmount, Discountable discount) {
		double finalPayable = discount.applyDiscount(totalAmount);

		System.out.println("\nCustomer Type: " + discount.getClass().getSimpleName() + "\nOriginal Amount: "
				+ totalAmount + "\nDiscount Applied: " + (totalAmount - finalPayable) + "\nFinal Payable Amount: "
				+ finalPayable);
	}

}
