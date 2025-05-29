package com.rbaalou.poc.product.repository;

import com.rbaalou.poc.product.dao.Product;
import com.rbaalou.poc.product.repository.NaturalId.NaturalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends NaturalRepository<Product, Long> {
}
