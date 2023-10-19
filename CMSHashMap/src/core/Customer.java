package core;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
	private static int idgenerator; //already initializes to zero in heap when object created
	private int customerId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	private double regAmount;
	private String password;
	private Plan servicePlan;

	public Customer(String firstName, String lastName, LocalDate dob, String email, double regAmount, String password,
			Plan servicePlan) {
		super();
		this.customerId = ++idgenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.regAmount = regAmount;
		this.password = password;
		this.servicePlan = servicePlan;
	}

//	public Customer(String email) {
//		this.email = email;
//	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email
				+ ", regAmount=" + regAmount + ", servicePlan=" + servicePlan + "]";
	}

	
	// No need to override equals and hashcode since key of map is string and it already implemented both
//	public boolean equals(Object o) {
//		if (o instanceof Customer) {
//			Customer cust = (Customer) o;
//			return this.email.equals(cust.email);
//		}
//		return false;
//
//	}
	
	

	public static int getIdgenerator() {
		return idgenerator;
	}

	public static void setIdgenerator(int idgenerator) {
		Customer.idgenerator = idgenerator;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Plan getServicePlan() {
		return servicePlan;
	}

	public void setServicePlan(Plan servicePlan) {
		this.servicePlan = servicePlan;
	}
	

}
