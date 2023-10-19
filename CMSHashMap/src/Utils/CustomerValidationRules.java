package Utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import CustomException.InvalidCustomerException;
import core.Customer;
import core.Plan;

public class CustomerValidationRules {
	// stringclass matches, contains, endswithmethod to check syntax

	public static void validUser(String email, Map<String, Customer> custMap) throws InvalidCustomerException {

//		Customer c = new Customer(email);
//		if (custList.contains(c))
//			throw new InvalidCustomerException("Customer with this email id already registered");

		//boolean java.util.Map.containsKey(Object key) [string is object]
		
		if (custMap.containsKey(email))
			throw new InvalidCustomerException("Customer with this email id already registered");
		//System.out.println("No duplicate");
	}

	public static Plan parseAndValidatePlan(String plan) throws IllegalArgumentException {
		return Plan.valueOf(plan.toUpperCase());
	}

	public static void PlanRegAmountValidate(Plan servicePlan, double regAmount) throws InvalidCustomerException {
		if (servicePlan.getPlanCost() != regAmount)
			throw new InvalidCustomerException("Registration amount does not match with selected plan");

	}
	
	public static LocalDate parseDOB (String dob)
	{
		return LocalDate.parse(dob);
	}

	public static Customer validateAllInputs(String firstName, String lastName, String dob, String email,
			double regAmount, String password, String inputPlan, Map<String,Customer> map)
			throws InvalidCustomerException {
		validUser(email, map);
		Plan servicePlan = parseAndValidatePlan(inputPlan);
		PlanRegAmountValidate(servicePlan, regAmount);
		//LocalDate dateOfBirth = LocalDate.parse(dob);
		LocalDate dateOfBirth = parseDOB(dob);

		Customer validCustomer = new Customer(firstName, lastName, dateOfBirth, email, regAmount, password,
				servicePlan);
		return validCustomer;

	}

}
