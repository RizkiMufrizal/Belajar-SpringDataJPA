package com.rizki.mufrizal.belajarSpringDataJPA.controller;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Customer;
import com.rizki.mufrizal.belajarSpringDataJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rizki on 06/09/15.
 */

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Page<Customer> getCustomers(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "jumlah") Integer jumlah){
        return customerService.findAllCustomer(page, jumlah);
    }

}
