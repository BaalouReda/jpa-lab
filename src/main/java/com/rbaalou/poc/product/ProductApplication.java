package com.rbaalou.poc.product;

import com.rbaalou.poc.product.repository.NaturalId.NaturalRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl.class)
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run (ProductApplication.class, args);
    }

}
