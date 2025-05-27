package com.rbaalou.poc.product.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "T_CATEGORY")
@SQLDelete(sql = "UPDATE T_CATEGORY SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category extends Auditing {

    private static final long serialVersionUID = 1582354163096302791L;

    @NaturalId
    @Enumerated(value = EnumType.STRING)
    @Column(unique = true,nullable = false,updatable = false)
    private CategoryType type;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "category_id")
    @OrderBy("materialNumber")
    private Set<Product> products;

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

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Category other = (Category) o;
        return Objects.equals(type, other.getType()) ;
    }

    public enum CategoryType {
        ELECTRONICS,
        CLOTHING,
        FOOD,
        FURNITURE,
        TOYS
    }
}
