package invoice;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class InvoiceTest {

	@Test
	public void testAddItemQuantity_severalQuantity() {
		Address billingAddress = null;
		Address shippingAddress = null;
		Customer customer = null;
		Product product = null;
		Invoice invoice = null;
		try {
			// Set up fixture
			billingAddress = new Address("12 rue Pierre Dupont", "Grenoble", "Isère", "38000", "Canada");
			shippingAddress = new Address("12 rue Pierre Dupont", "Grenoble", "Isère", "38000", "Canada");
			customer = new Customer(99, "Auguste", "Blanc", new BigDecimal("30"), billingAddress, shippingAddress);
			product = new Product(88, "TV", new BigDecimal("19.99"));
			invoice = new Invoice(customer);
			
			//Exercise SUT
			invoice.addItemQuantity(product, 5);
			// Verify outcome
			List<LineItem> lineItems = invoice.getLineItems();
			if (lineItems.size() == 1) {
				LineItem actItem = lineItems.get(0);
				assertEquals("inv",  invoice, actItem.getInv());
				assertEquals("prod", product, actItem.getProd());
				assertEquals("quant", 5, actItem.getQuantity());
				assertEquals("discount", new BigDecimal("30"), actItem.getPercentDiscount());
				assertEquals("unit price", new BigDecimal("19.99"), actItem.getUnitPrice());
				assertEquals("extended price", new BigDecimal("69.96"), actItem.getUnitPrice());
			}
			
		} finally {
			// TODO: handle exception
		}
	}

}
