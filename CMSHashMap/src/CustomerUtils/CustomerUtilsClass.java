package CustomerUtils;

import java.util.Map;

import CustomException.InvalidCustomerException;
import core.Customer;

public class CustomerUtilsClass {

	public static Customer authenticateCustomer(String email, String password, Map<String, Customer> customers)
			throws InvalidCustomerException {
		Customer validCustomer = customers.get(email);
		if (validCustomer == null)
			throw new InvalidCustomerException("Invalid customer");
		if (!validCustomer.getPassword().equals(password))
			throw new InvalidCustomerException("Wrong password");
		return validCustomer;

	}

	public static void changePassword(String email, String password, String newpassword,
			Map<String, Customer> customers) throws InvalidCustomerException {
		Customer validCustomer = authenticateCustomer(email, password, customers);
		validCustomer.setPassword(newpassword);
		System.out.println("Password successfully updated");

	}

	public static void unsubscribeCustomer(String email, String password, Map<String, Customer> customers)
			throws InvalidCustomerException {
		Customer validCustomer = authenticateCustomer(email, password, customers);
		customers.remove(email);
		System.out.println("Customer successfully unsubscribed from system");
	}

	public static void displayAll(Map<String, Customer> customers) {
		for (Customer c : customers.values())
			System.out.println(c);
	}

}
