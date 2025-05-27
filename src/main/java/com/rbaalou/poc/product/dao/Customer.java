package com.rbaalou.poc.product.dao;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "T_CUSTOMER")
@SQLDelete(sql = "UPDATE T_CUSTOMER SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {
    private static final long serialVersionUID = -3037922050955755622L;
}
