package invoice;

import java.math.BigDecimal;

public class Product {

	private BigDecimal unitPrice;

	public Product(int id, String name, BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

}
