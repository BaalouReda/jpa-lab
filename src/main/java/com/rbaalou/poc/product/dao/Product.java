package com.rbaalou.poc.product.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "T_PRODUCT")
@SQLDelete(sql = "UPDATE T_PRODUCT SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product extends Auditing {

    private static final long serialVersionUID = 1582354163096302791L;

    @NaturalId
    @Column(unique = true,nullable = false,updatable = false, length = 10)
    private String materialNumber;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Product other = (Product) o;
        return Objects.equals(materialNumber, other.getMaterialNumber ()) ;
    }
}
