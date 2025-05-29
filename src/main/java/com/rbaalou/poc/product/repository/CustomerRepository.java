package com.rbaalou.poc.product.repository;

import com.rbaalou.poc.product.dao.Customer;
import com.rbaalou.poc.product.repository.NaturalId.NaturalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends NaturalRepository<Customer, Long> {
}
