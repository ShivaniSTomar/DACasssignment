package Utils;

import java.time.LocalDate;
import java.util.List;

import CustomException.InvalidCustomerException;
import core.Customer;
import core.Plan;

public class CustomerValidationRules {
	// password check

	public static void validUser(String email, List<Customer> custList) throws InvalidCustomerException {

		Customer c = new Customer(email);

		if (custList.contains(c))
			throw new InvalidCustomerException("Customer with this email id already registered");
	}

	public static Plan parseAndValidatePlan(String plan) throws IllegalArgumentException {
		String plaN = plan.toUpperCase();
		return Plan.valueOf(plaN);
	}

	public static void PlanRegAmountValidate(Plan servicePlan, double regAmount) throws InvalidCustomerException {
		if (servicePlan.getPlanCost() != regAmount)
			throw new InvalidCustomerException("Registration amount does not match with selected plan");

	}

	public static Customer validateAllInputs(String firstName, String lastName, String dob, String email,
			double regAmount, String password, String inputPlan, List<Customer> custList)
			throws InvalidCustomerException {
		validUser(email, custList);
		Plan servicePlan = parseAndValidatePlan(inputPlan);
		PlanRegAmountValidate(servicePlan, regAmount);
		LocalDate dateOfBirth = LocalDate.parse(dob);

		Customer validCustomer = new Customer(firstName, lastName, dateOfBirth, email, regAmount, password,
				servicePlan);
		return validCustomer;

	}

}
