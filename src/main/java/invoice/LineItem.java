package invoice;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class LineItem {

	private Invoice invoice;
	private Product product;
	private int quantity;
	private BigDecimal discount;

	public LineItem(Invoice invoice, Product product, int quantity, BigDecimal percentDiscount) {
		this.invoice = invoice;
		this.product = product;
		this.quantity = quantity;
		this.discount = percentDiscount;
	}

	public Invoice getInv() {
		return invoice;
	}

	public Product getProd() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPercentDiscount() {
		return discount;
	}

	public BigDecimal getUnitPrice() {
		return product.getUnitPrice();
	}

	public BigDecimal getExtendedPrice() {
		BigDecimal percentDiscount = BigDecimal.valueOf(1).subtract(discount.movePointLeft(2));
		MathContext mc = new MathContext(4, RoundingMode.HALF_DOWN);
		return getUnitPrice().multiply(BigDecimal.valueOf(getQuantity()).multiply(percentDiscount)).round(mc );
	}

}
