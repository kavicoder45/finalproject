package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerrepository;

	public List<Customer> getAllCustomerDetails() {
		return customerrepository.findAll();
	}

	public Customer saveCustomerDetails(Customer customer) {
		return customerrepository.save(customer);
	}

	public List<Customer> getCustomerWithSorting(String field) {
		return customerrepository.findAll(Sort.by(Sort.Direction.DESC, field));
	}

	public Page<Customer> getCustomerWithPagination(int offset, int pageSize) {
		Page<Customer> products = customerrepository.findAll(PageRequest.of(offset, pageSize));
		return products;
	}

	public boolean updateCustomer(Customer customer, Integer id) {

		Optional<Customer> existingcustomer = customerrepository.findById(id);

		if (existingcustomer.isPresent()) {
			Customer existcustomer = existingcustomer.get();
			existcustomer.setCustomerName(customer.getCustomerName());
			existcustomer.setCustomerMobileNo(customer.getCustomerMobileNo());
			customerrepository.save(existcustomer);
			return true;
		} else {
			return false;
		}
	}
	
	
}
