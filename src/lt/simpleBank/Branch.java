package lt.simpleBank;

import java.util.ArrayList;

public class Branch {

	private ArrayList<Customer> customers;

	private String name;

	public Branch(String name) {
		super();
		this.customers = new ArrayList<>();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	

	public ArrayList<Customer> getCustomers() {
		return customers;
	}


	public boolean addCustomer(String customerName, double initialAmount) {
		// contact exist if index is >= 0
		if (findCustomer(customerName) == null) {
			this.customers.add(new Customer(customerName, initialAmount));
			System.out.println("New Customer added successfully!");

			return true;
		}
		System.out.println("Customer is already on exist");
		return false;
	}

	public boolean addCustomerTransaction(String customerName, double amount) {
		Customer existingCustomer = findCustomer(customerName);
		if (existingCustomer != null) {
			// method from Customer class
			existingCustomer.addTransaction(amount);
			System.out.println("Transaction success for "+ existingCustomer.getName() + "!" );
			return true;
		}
		System.out.println("Customer does not found.");
		return false;
	}

	// showing position int the array
//	private int findCustomer(Customer customer) {
//		return this.customers.indexOf(customer);
//	}

	private Customer findCustomer(String customerName) {
		for (int i = 0; i < this.customers.size(); i++) {
			Customer customer = this.customers.get(i);
			if (customer.getName().equals(customerName)) {
				return customer;
			}
		}
		// if customer was not found.
		return null;
	}

}
