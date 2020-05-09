package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.customer.dao.AddressDAO;
import com.customer.dao.CustomerDAO;
import com.customer.dao.GenderDAO;
import com.customer.entity.Address;
import com.customer.entity.Customer;
import com.customer.entity.Gender;
import com.customer.model.AddressVO;
import com.customer.model.CustomerVO;
import com.customer.model.GenderVO;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private GenderDAO genderDAO;

	public List<CustomerVO> getAllCustomer() {
		List<CustomerVO> customerVOs = new ArrayList<CustomerVO>();
		List<Customer> customers = customerDAO.fetchAllCustomer();
		if (!CollectionUtils.isEmpty(customers)) {
			for (Customer customer : customers) {
				CustomerVO customerVO = new CustomerVO();
				customerVOs.add(setCustomerDetails(customer, customerVO));
			}
		}
		return customerVOs;
	}

	public void saveOrUpdateCustomer(CustomerVO customerVO) {
		Customer customer = null;
		Address address = null;
		if (customerVO != null && customerVO.getId()!=null) {
			customer = customerDAO.fetchCustomerById(customerVO.getId());
		} else {
			customer = new Customer();
		}
		customer.setFirstName(customerVO.getFirstName());
		customer.setLastName(customerVO.getLastName());
		customer.setDateOfBirth(customerVO.getDateOfBirth());
		customer.setEmail(customerVO.getEmail());
		customer.setMobileNumber(customerVO.getMobileNumber());
		customer.setUserName(customerVO.getUserName());
		customer.setPassword(customerVO.getPassword());
		if (customerVO != null && customerVO.getGenderVO() != null && customerVO.getGenderVO().getId() != null) {
			Gender customerGender = genderDAO.fetchGenderById(customerVO.getGenderVO().getId());
			customer.setGender(customerGender);
		}
		if (customerVO != null && customerVO.getAddressVO() != null && customerVO.getAddressVO().getId() != null) {
			address = addressDAO.fetchAddressById(customerVO.getAddressVO().getId());
		} else {
			address = new Address();
		}
		address.setAddressLine1(customerVO.getAddressVO().getAddressLine1());
		address.setAddressLine2(customerVO.getAddressVO().getAddressLine2());
		address.setPostcode(customerVO.getAddressVO().getPostcode());
		address.setTown(customerVO.getAddressVO().getTown());
		address.setCountry(customerVO.getAddressVO().getCountry());
		if (address != null) {
			addressDAO.saveOrUpdateCustomer(address);
			customer.setAddress(address);
		}
		customerDAO.saveOrUpdateCustomer(customer);
	}

	public void deleteCustomerById(Integer customerId) {
		if (customerId != null) {
			Customer customer = customerDAO.fetchCustomerById(customerId);
			if (customer != null) {
				if (customer.getAddress() != null && customer.getAddress().getId() != null) {
					addressDAO.deleteAddressById(customer.getAddress().getId());
				}
				customerDAO.deleteCustomerById(customer.getId());
			}
		}
	}

	public CustomerVO findCustomerById(Integer customerId) {
		CustomerVO customerVO = null;
		if (customerId != null) {
			Customer customer = customerDAO.fetchCustomerById(customerId);
			if (customer != null) {
				customerVO = setCustomerDetails(customer, new CustomerVO());
			}
		}
		return customerVO;
	}

	private CustomerVO setCustomerDetails(Customer customer, CustomerVO customerVO) {
		customerVO.setId(customer.getId());
		customerVO.setFirstName(customer.getFirstName());
		customerVO.setLastName(customer.getLastName());
		if (customer.getAddress() != null) {
			Address address = customer.getAddress();
			AddressVO addressVO = new AddressVO();
			addressVO.setId(address.getId());
			addressVO.setAddressLine1(address.getAddressLine1());
			addressVO.setAddressLine2(address.getAddressLine2());
			addressVO.setPostcode(address.getPostcode());
			addressVO.setTown(address.getTown());
			addressVO.setCountry(address.getCountry());
			customerVO.setAddressVO(addressVO);
		}
		if (customer.getGender() != null) {
			Gender gender = customer.getGender();
			GenderVO genderVO = new GenderVO();
			genderVO.setId(gender.getId());
			genderVO.setName(gender.getName());
			customerVO.setGenderVO(genderVO);
		}
		customerVO.setDateOfBirth(customer.getDateOfBirth());
		customerVO.setEmail(customer.getEmail());
		customerVO.setMobileNumber(customer.getMobileNumber());
		customerVO.setUserName(customer.getUserName());
		customerVO.setPassword(customer.getPassword());
		return customerVO;
	}

	public List<GenderVO> fetchAllGender() {
		List<GenderVO> genderVOs = new ArrayList<GenderVO>();
		List<Gender> genders = genderDAO.fetchAllGender();
		for (Gender gender : genders) {
			GenderVO genderVO = new GenderVO();
			genderVO.setId(gender.getId());
			genderVO.setName(gender.getName());
			genderVOs.add(genderVO);
		}
		return genderVOs;
	}

}
