package com.rbaalou.poc.product.repository.NaturalId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;


@NoRepositoryBean
public interface NaturalRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    Optional<T> findBySimpleNaturalId(ID naturalId);
    void deleteBySimpleNaturalId(ID naturalId);
}
