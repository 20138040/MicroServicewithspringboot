package com.oauth2Server.oauth2Server.controller;

import com.oauth2Server.oauth2Server.MicroServiceCheck.CustomerProducts;
import com.oauth2Server.oauth2Server.model.Customer;
import com.oauth2Server.oauth2Server.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    int x = 232;

    private final CustomerService customerService;
    private final Logger logger;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        this.logger = LoggerFactory.getLogger(Customer.class);
    }

    @GetMapping("/all")
    @ApiOperation(value = "returns all the customers", notes = "my note", response = Customer.class)
    public List<Customer> Customers(){
        logger.info("Getting all customers details");
        return customerService.getCustomers();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("delete/{id}")
    public void removeCustomer(@PathVariable("id") int id){
         customerService.deleteCustomer(id);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @GetMapping("custwithproduct/{id}")
    public CustomerProducts getCustomerWithProducts(@PathVariable("id") int id){
        return customerService.getCustomersWithProducts(id);
    }
}
