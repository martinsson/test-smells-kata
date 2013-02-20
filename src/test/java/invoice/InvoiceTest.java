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
			List<LineItem> liteItems = invoice.getLineItems();
			
		} finally {
			// TODO: handle exception
		}
	}

}
