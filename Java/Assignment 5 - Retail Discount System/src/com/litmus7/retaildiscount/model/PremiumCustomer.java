package com.litmus7.retaildiscount.model;

/**
 * Represents a premium customer who receives a tiered discount based on the
 * total amount.
 */
public class PremiumCustomer implements Discountable {

	/**
	 * Applies a tiered discount to the given total amount for premium customers.
	 * 
	 * @param totalAmount the original total amount before discount
	 * @return the final payable amount after applying the appropriate discount
	 */
	@Override
	public double applyDiscount(double totalAmount) {

		double discount = totalAmount > 5000 ? 0.1 * totalAmount : 0.07 * totalAmount;
		double finalPayable = totalAmount - discount;
		return finalPayable;
	}

}
