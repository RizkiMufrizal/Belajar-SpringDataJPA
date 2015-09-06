package com.rizki.mufrizal.belajarSpringDataJPA.service.impl;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Customer;
import com.rizki.mufrizal.belajarSpringDataJPA.repository.CustomerRepository;
import com.rizki.mufrizal.belajarSpringDataJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rizki on 06/09/15.
 */

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String idCustomer) {
        return customerRepository.findOne(idCustomer);
    }

    @Override
    public Page<Customer> findAllCustomer(Integer page, Integer jumlah) {
        return customerRepository.findAll(new PageRequest(page - 1, jumlah));
    }
}
