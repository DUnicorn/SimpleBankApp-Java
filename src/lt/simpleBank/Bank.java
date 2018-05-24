package lt.simpleBank;

import java.util.ArrayList;

public class Bank {

	private String name;

	private ArrayList<Branch> branches;

	public Bank(String name) {
		super();
		this.name = name;
		this.branches = new ArrayList<Branch>();
	}

	public boolean addBranch(String branchName) {
		// contact exist if index is >= 0
		if (findBranch(branchName) == null) {
			this.branches.add(new Branch(branchName));
			System.out.println("New Branch -" + branchName + " added successfully!");

			return true;
		}
		return false;
	}

	public boolean addCustomerToBranch(String branchName, String customerName, double initialAmount) {
		Branch branch = findBranch(branchName);
		// add customer if branch exists(name)
		if (branch != null) {
			// addCustomer method return boolean;
			System.out.println("Customer " + customerName + " added to Branch" + branchName + "!");
			return branch.addCustomer(customerName, initialAmount);
		}
		System.out.println("Something wrong");
		return false;

	}

	public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			return branch.addCustomerTransaction(customerName, amount);
		}
		return false;

	}

	public boolean listCustomers(String branchName, boolean showTransactions) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			System.out.println("Customers details for branch " + branch.getName());

			ArrayList<Customer> branchCustomers = branch.getCustomers();
			for (int i = 0; i < branchCustomers.size(); i++) {
				Customer branchCustomer = branchCustomers.get(i);
				System.out.println("Customer: " + branchCustomer.getName() + " [" + (i + 1) + "]");
				if (showTransactions) {
					System.out.println("Transactions: ");
					ArrayList<Double> transactions = branchCustomer.getTransactions();
					for (int j = 0; j < transactions.size(); j++) {
						System.out.println("[ " + (j + 1) + " ] Amount " + transactions.get(j));
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	private Branch findBranch(String branchName) {
		for (int i = 0; i < this.branches.size(); i++) {
			Branch branch = this.branches.get(i);
			if (branch.getName().equals(branchName)) {
				return branch;
			}
		}
		return null;
	}

}
