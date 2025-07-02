package com.litmus7.retaildiscount.model;

/**
 * Represents a wholesale customer who receives a discount based on the total
 * amount.
 */
public class WholesaleCustomer implements Discountable {

	/**
	 * Applies a discount to the given total amount based on wholesale pricing
	 * rules.
	 * 
	 * @param totalAmount the original total amount before discount
	 * @return the final payable amount after applying the appropriate discount
	 */
	@Override
	public double applyDiscount(double totalAmount) {

		double discount = totalAmount > 10000 ? 0.15 * totalAmount : 0.1 * totalAmount;
		double finalPayable = totalAmount - discount;
		return finalPayable;
	}

}
