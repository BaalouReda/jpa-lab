package com.rbaalou.poc.product.repository;

import com.rbaalou.poc.product.dao.Category;
import com.rbaalou.poc.product.repository.NaturalId.NaturalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends NaturalRepository<Category, Long> {
}
