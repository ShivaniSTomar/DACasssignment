package tester;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import CustomException.InvalidCustomerException;
import core.Customer;
import static Utils.CustomerValidationRules.*;
import static CustomerUtils.CustomerUtilsClass.*;

public class CustomerManagementSystem {

	public static void main(String[] args) throws InvalidCustomerException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome");
			List<Customer> customerList = new ArrayList<Customer>();
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Select \n1.Sign up \n2.Sign in \n3.Change password \n4.Unsubscribe customer \n5.Display all Customer \n0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter customer details : firstName, lastName, dob, email, regAmount, password, servicePlan");
						Customer validatedCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customerList);
						customerList.add(validatedCustomer);
						System.out.println("Customer successfully added");

						break;
					case 2:
						System.out.println("Enter email and password to login");
						loginCustomer(sc.next(), sc.next(), customerList);
						break;
					case 3:
						System.out.println("Enter email id and password to change password");
						String eMail = sc.next();
						String passWord = sc.next();
						loginCustomer(eMail, passWord, customerList);
						System.out.println("Enter new password");
						String newpassword = sc.next();
						changePassword(eMail, passWord, newpassword, customerList);
						System.out.println("Password successfully updated");
						break;
					case 4:
						System.out.println("Enter email id and password to unsubscribe");
						eMail = sc.next();
						passWord = sc.next();
						loginCustomer(eMail, passWord, customerList);
						System.out.println("Enter yes to unsubscribe");
						String yes = sc.next();
						unsubscribeCustomer(eMail, passWord, customerList);
						break;
					case 5:
						System.out.println("All customer details");
						displayAll(customerList);
						break;
					case 0:
						System.out.println("END");
						exit = true;
						break;
					default:
						System.out.println("Please select valid options");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
