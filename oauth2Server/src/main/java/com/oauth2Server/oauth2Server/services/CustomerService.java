package com.oauth2Server.oauth2Server.services;

import com.oauth2Server.oauth2Server.MicroServiceCheck.CustomerProducts;
import com.oauth2Server.oauth2Server.MicroServiceCheck.Products;
import com.oauth2Server.oauth2Server.model.Customer;
import com.oauth2Server.oauth2Server.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public CustomerProducts getCustomersWithProducts(Integer custId) {
        CustomerProducts customerProducts = new CustomerProducts();
        Customer customer = customerRepository.findById(custId).orElse(new Customer());

        var product =  restTemplate
                .getForEntity("http://PRODUCT-SERVICE/products/custId/"+custId,Products[].class);

        customerProducts.setCustomer(customer);
        customerProducts.setProducts(Arrays.asList(product.getBody()));

        return  customerProducts;
    }
}
