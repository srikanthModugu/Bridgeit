package com.bridgeit.springJdbcDemo;

public interface CustomerDao {
	
	public void addCustomer(Customer coustomer);
	public Customer getCustomerByID(int id);

}
