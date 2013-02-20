package invoice;

import java.math.BigDecimal;

public class Customer {

	private BigDecimal discountRate;

	public Customer(int customerId, String givenName, String surName,
			BigDecimal discountRate, Address billingAddress,
			Address shippingAddress) {
				this.discountRate = discountRate;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

}
