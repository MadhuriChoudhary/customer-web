package com.customer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.Gender;

@Repository
public class GenderDAOImpl implements GenderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Gender> fetchAllGender() {
		Criteria criteria = getSession().createCriteria(Gender.class);
		return (List<Gender>) criteria.list();
	}

	public Gender fetchGenderById(Integer genderId) {
		Gender gender = (Gender) getSession().get(Gender.class, genderId);
		return gender;
	}
}
