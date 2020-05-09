package com.customer.dao;

import java.util.List;

import com.customer.entity.Customer;

public interface CustomerDAO {

	public List<Customer> fetchAllCustomer();
	public void saveOrUpdateCustomer(Customer customer);
	public void deleteCustomerById(Integer customerId);
	public Customer fetchCustomerById(Integer customerId);
	
}
