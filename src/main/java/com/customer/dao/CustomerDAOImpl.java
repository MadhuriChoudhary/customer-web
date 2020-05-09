package com.customer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> fetchAllCustomer() {
		Criteria criteria = getSession().createCriteria(Customer.class);
		return (List<Customer>) criteria.list();
	}

	public void saveOrUpdateCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
	}

	public void deleteCustomerById(Integer customerId) {
		Customer customer = (Customer) getSession().get(Customer.class, customerId);
		getSession().delete(customer);
	}

	public Customer fetchCustomerById(Integer customerId) {
		Customer customer = (Customer) getSession().get(Customer.class, customerId);
		return customer;
	}

}
