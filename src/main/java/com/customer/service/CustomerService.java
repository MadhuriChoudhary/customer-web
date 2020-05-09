package com.customer.service;

import java.util.List;

import com.customer.model.CustomerVO;
import com.customer.model.GenderVO;

public interface CustomerService {
	
	public List<CustomerVO> getAllCustomer();
	public void saveOrUpdateCustomer(CustomerVO customerVO);
	public void deleteCustomerById(Integer customerId);
	public CustomerVO findCustomerById(Integer customerId);
	public List<GenderVO> fetchAllGender();
}
