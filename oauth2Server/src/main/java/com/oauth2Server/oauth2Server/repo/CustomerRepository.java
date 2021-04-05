package com.oauth2Server.oauth2Server.repo;

import com.oauth2Server.oauth2Server.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
