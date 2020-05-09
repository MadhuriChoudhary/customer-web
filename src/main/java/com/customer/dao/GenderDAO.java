package com.customer.dao;

import java.util.List;

import com.customer.entity.Gender;

public interface GenderDAO {
	public List<Gender> fetchAllGender();
	public Gender fetchGenderById(Integer genderId);
}
