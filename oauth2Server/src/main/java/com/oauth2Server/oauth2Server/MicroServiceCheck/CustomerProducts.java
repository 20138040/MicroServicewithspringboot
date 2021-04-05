package com.oauth2Server.oauth2Server.MicroServiceCheck;

import com.oauth2Server.oauth2Server.model.Customer;

import java.util.List;

public class CustomerProducts {

    private List<Products> products;
    private Customer customer;

    public CustomerProducts(List<Products> products, Customer customer) {
        this.products = products;
        this.customer = customer;
    }

    public CustomerProducts() {

    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerProducts{" +
                "products=" + products +
                ", customer=" + customer +
                '}';
    }
}
