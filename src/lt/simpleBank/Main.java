package lt.simpleBank;

public class Main {

	public static void main(String[] args) {

		Bank bank = new Bank("Danske");

		bank.addBranch("Vilnius");

		bank.addCustomerToBranch("Vilnius", "Bob", 202.2);
		bank.addCustomerToBranch("Vilnius", "Tom", 10.5);
		bank.addCustomerToBranch("Vilnius", "Jhon", 2.0);

		bank.addBranch("Kaunas");

		bank.addCustomerToBranch("Kaunas", "Jimm", 150.0);

		bank.addCustomerTransaction("Vilnius", "Bob", 7.8);
		bank.addCustomerTransaction("Vilnius", "Jhon", 1);
		bank.addCustomerTransaction("Kaunas", "Jimm", 0.5);

		bank.listCustomers("Vilnius", true);

		bank.listCustomers("Kaunas", true);

		bank.addBranch("Siauliai");

		if (!bank.addCustomerToBranch("Siauliai", "Brian", 5.45)) {
			System.out.println("Error branch do not exists");
		}

		if (!bank.addBranch("Vilnius")) {
			System.out.println("Vilnius branch already exists");
		}

		if (!bank.addCustomerTransaction("Vilnius", "Don", 52)) {
			System.out.println("Customer does not exist at Branch ");
		}

		if(!bank.addCustomerToBranch("Vilnius", "Bob",20)) {
			System.out.println("Customer Bob already exists");
		}
	}

}
