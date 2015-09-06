package com.rizki.mufrizal.belajarSpringDataJPA.controller;

import com.rizki.mufrizal.belajarSpringDataJPA.domain.Customer;
import com.rizki.mufrizal.belajarSpringDataJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
            @RequestParam(value = "jumlah") Integer jumlah) {
        return customerService.findAllCustomer(page, jumlah);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/customer/{idCustomer}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer getCustomer(@PathVariable("idCustomer") String idCustomer) {
        return customerService.getCustomer(idCustomer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/customer", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, Object> saveCustomer(@RequestBody Customer customer) {

        HashMap<String, Object> objectHashMap = new HashMap<>();

        if (customer == null) {
            objectHashMap.put("Success", Boolean.FALSE);
            objectHashMap.put("Info", "Data tidak ada yang terkirim");
            return objectHashMap;
        } else {
            customerService.saveCustomer(customer);
        }

        objectHashMap.put("Success", Boolean.TRUE);
        objectHashMap.put("Info", "Data berhasil disimpan");
        return objectHashMap;

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/customer", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HashMap<String, Object> updateCustomer(@RequestBody Customer customer) {

        HashMap<String, Object> objectHashMap = new HashMap<>();

        if (customer == null) {
            objectHashMap.put("Success", Boolean.FALSE);
            objectHashMap.put("Info", "Data tidak ada yang terkirim");
            return objectHashMap;
        } else {
            customerService.updateCustomer(customer);
        }

        objectHashMap.put("Success", Boolean.TRUE);
        objectHashMap.put("Info", "Data berhasil diedit");
        return objectHashMap;

    }

}
