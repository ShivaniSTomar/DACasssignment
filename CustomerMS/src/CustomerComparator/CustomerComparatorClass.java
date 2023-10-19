package CustomerComparator;

import java.time.Period;

import core.Customer;

public class CustomerComparatorClass {
	public static void compare(Customer cust1, Customer cust2)
	{
		//Sort customer details as per dob n last name (use custom ordering)
		if (Period.between(cust1.getDob(), cust2.getDob()) != null)
		{
			
		}
		
		
	}

}
