package com.rizki.mufrizal.belajarSpringDataJPA.service;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Customer;
import org.springframework.data.domain.Page;

/**
 * Created by rizki on 06/09/15.
 */
public interface CustomerService {

    Page<Customer> findAllCustomer(Integer page, Integer jumlah);

}
