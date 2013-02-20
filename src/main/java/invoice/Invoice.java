package invoice;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

	List<LineItem> items = new ArrayList<LineItem>();
	private Customer customer;
	
	public Invoice(Customer customer) {
		this.customer = customer;
	}

	public void addItemQuantity(Product product, int quantity) {
		LineItem lineItem = new LineItem(this, product, quantity, customer.getDiscountRate());
		items.add(lineItem);
	}

	public List<LineItem> getLineItems() {
		return items;
	}

}
