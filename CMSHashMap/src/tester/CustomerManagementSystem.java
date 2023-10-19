package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import CustomException.InvalidCustomerException;
import core.Customer;
import static Utils.CustomerValidationRules.*;
import static CustomerUtils.CustomerUtilsClass.*;

public class CustomerManagementSystem {

	public static void main(String[] args) throws InvalidCustomerException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome");
			Map<String, Customer> customers = new HashMap<>();
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Select \n1.Sign up \n2.Sign in \n3.Change password \n4.Unsubscribe customer \n5.Display all Customer \n0.Exit");
				try {
					switch (sc.nextInt()) {

					case 1:
						System.out.println(
								"Enter customer details : firstName, lastName, dob(yyyy-mm-dd), email, regAmount, password, servicePlan");
						Customer validatedCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(validatedCustomer.getEmail(), validatedCustomer);
						System.out.println("Customer successfully added");
						break;

					case 2:
						System.out.println("Enter email and password to login");
						Customer authenticatedCustomer = authenticateCustomer(sc.next(), sc.next(), customers);
						System.out.println("Successfully logged in \n"+authenticatedCustomer);
						break;

					case 3:
						System.out.println("Enter email id and password to change password");
						changePassword(sc.next(), sc.next(), sc.next(), customers);
						break;

					case 4:
						System.out.println("Enter email id and password to unsubscribe");
						unsubscribeCustomer(sc.next(), sc.next(), customers);
						break;
					case 5:
						System.out.println("All customer details");
						displayAll(customers);
						break;
					case 0:
						System.out.println("END");
						exit = true;
						break;
					default:
						System.out.println("Please select valid option");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
	}

}
