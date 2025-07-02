package com.litmus7.retaildiscount.model;

/**
 * Represents a regular customer who receives a fixed 5% discount on the total
 * purchase amount.
 */
public class RegularCustomer implements Discountable {

	/**
	 * Applies a 5% discount to the given total amount.
	 *
	 * @param totalAmount the original total amount before discount
	 * @return the final payable amount after applying a 5% discount
	 */
	@Override
	public double applyDiscount(double totalAmount) {

		double discount = 0.05 * totalAmount;
		double finalPayable = totalAmount - discount;
		return finalPayable;
	}

}
