package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.customer.model.CustomerVO;
import com.customer.model.GenderVO;
import com.customer.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/list")
	public ModelAndView getCustomerList() {
		ModelAndView model = new ModelAndView("customer/list");
		List<CustomerVO> customers = customerService.getAllCustomer();
		model.addObject("customers", customers);
		return model;
	}

	@GetMapping(value = "/update/{id}")
	public ModelAndView updateCustomer(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("customer/form");
		CustomerVO customer = customerService.findCustomerById(id);
		model.addObject("customerForm", customer);
		List<GenderVO> genders = customerService.fetchAllGender();
		model.addObject("genders", genders);
		model.addObject("readonly", true);
		return model;
	}

	@GetMapping(value = "/add")
	public ModelAndView updateCustomer() {
		ModelAndView model = new ModelAndView("customer/form");
		CustomerVO customer = new CustomerVO();
		model.addObject("customerForm", customer);
		List<GenderVO> genders = customerService.fetchAllGender();
		model.addObject("genders", genders);
		return model;
	}

	@PostMapping(value = "/save")
	public ModelAndView saveCustomer(@ModelAttribute("customerForm") CustomerVO customerVO) {
		customerService.saveOrUpdateCustomer(customerVO);
		return new ModelAndView("redirect:/customer/list");
	}
	
	@GetMapping(value = "/delete/{id}")
	public ModelAndView deleteCustomer(@PathVariable("id") Integer id) {
		customerService.deleteCustomerById(id);
		return new ModelAndView("redirect:/customer/list");
	}

}
