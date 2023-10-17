package CustomerUtils;

import java.util.List;

import CustomException.InvalidCustomerException;
import core.Customer;

public class CustomerUtilsClass {
	public static void loginCustomer(String email, String password, List<Customer> custList)
			throws InvalidCustomerException {
		Customer custLogin = new Customer(email);
		if (custList.contains(custLogin)) {
			int index = custList.indexOf(custLogin);
			Customer validEmail = custList.get(index);
			if (validEmail.getPassword().equals(password)) {
				System.out.println("Successfully logged in");
			} else {
				throw new InvalidCustomerException("Wrong password");
			}
		} else {
			throw new InvalidCustomerException("Customer with this email id does not exist");
		}
	}

	public static void changePassword(String email, String password, String newpassword, List<Customer> custList) {
		Customer custLogin = new Customer(email);
		int index = custList.indexOf(custLogin);
		Customer validEmail = custList.get(index);
		validEmail.setPassword(newpassword);
	}
	
	public static void unsubscribeCustomer(String email, String password, List<Customer> custList) {
		Customer custLogin = new Customer(email);
		int index = custList.indexOf(custLogin);
		Customer validEmail = custList.get(index);
		custList.remove(index);
		System.out.println("Customer successfully unsubscribed from system");

	}
	
	public static void displayAll(List<Customer> custList)
	{
		for (Customer custall : custList)
			System.out.println(custall);
	}

}
