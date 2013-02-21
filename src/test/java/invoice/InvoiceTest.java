package invoice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Test;

public class InvoiceTest {

	private List<Object> objectsToClean = new ArrayList<Object>();;

    @Test
	public void testAddItemQuantity_severalQuantity() {
        BigDecimal discountRate = new BigDecimal("30");
        BigDecimal price = new BigDecimal("19.99");

        Product product = aProductThatCosts(price);
        Invoice invoice = anInvoiceWith(aCustomerWithDiscountRate(discountRate));
                
        
        //Exercise SUT
        int quantity = 5;
        invoice.addItemQuantity(product, quantity);
        
        // Verify outcome
        List<LineItem> lineItems = invoice.getLineItems();
        assertEquals(1, lineItems.size());
        LineItem actItem = lineItems.get(0);
        assertEquals("inv",  invoice, actItem.getInv());
        BigDecimal expectedTotal = new BigDecimal("69.96");
        assertEquals("extended price", expectedTotal, actItem.getExtendedPrice());

        //        assertEquals(expectedLineItem, actItem);
	}

    private Invoice anInvoiceWith(Customer aCustomerWithDiscountRate) {
        return new Invoice(aCustomerWithDiscountRate);
    }

    private Product aProductThatCosts(BigDecimal unitPrice) {
        return new Product(88, "TV", unitPrice);
    }

    private Customer aCustomerWithDiscountRate(BigDecimal discountRate) {
        Address billingAddress = anAddress();
        Address shippingAddress = anAddress();
        // Set up fixture
        Customer customer = new Customer(99, "Auguste", "Blanc", discountRate, billingAddress, shippingAddress);
        return customer;
    }

    
     
    @After
    public void initBeforeTest() throws Exception {
        for (Object object : objectsToClean) {
            try {
                deleteObject(object);
            } catch (Throwable e) {
                // do something to make the test fail after cleaning up all objects (@Rule ExternalRessource)
            }
        }
        
    }
    private Address anAddress() {
        Address address = new Address("12 rue Robert Dumont", "Grenoble", "Is�re", "38000", "France");
        objectsToClean.add(address);
        return address;
    }

    private Address registerObject() {
        
        Address address = new Address("12 rue Robert Dumont", "Grenoble", "Is�re", "38000", "France");
        objectsToClean.add(address);
        return address;
    }

	private void deleteObject(Object object) {
		// some logic to delete object from database
		
		sometimesSomethingGoesWrong();
	}

	private void sometimesSomethingGoesWrong() {
		if (new Random(70).nextInt() == 37) {
			throw new DatabaseException();
		}
	}

}
