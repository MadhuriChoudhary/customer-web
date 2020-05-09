package com.customer.dao;

import com.customer.entity.Address;

public interface AddressDAO {
	public void saveOrUpdateCustomer(Address address);
	public void deleteAddressById(Integer addressId);
	public Address fetchAddressById(Integer addressId);
}
