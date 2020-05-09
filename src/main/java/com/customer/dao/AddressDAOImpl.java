package com.customer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.Address;
import com.customer.entity.Customer;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdateCustomer(Address address) {
		getSession().saveOrUpdate(address);
	}

	public void deleteAddressById(Integer addressId) {
		Address address = (Address) getSession().get(Address.class, addressId);
		getSession().delete(address);
	}

	public Address fetchAddressById(Integer addressId) {
		Address address = (Address) getSession().get(Address.class, addressId);
		return address;
	}

}
