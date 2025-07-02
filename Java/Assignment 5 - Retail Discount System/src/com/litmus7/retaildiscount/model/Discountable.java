package com.litmus7.retaildiscount.model;

public interface Discountable {

	/**
	 * Represents a discount strategy that can be applied to a total amount.
	 * 
	 * @param totalAmount
	 * @return
	 */
	public double applyDiscount(double totalAmount);
}
