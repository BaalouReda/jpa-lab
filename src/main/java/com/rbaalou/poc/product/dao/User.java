package com.rbaalou.poc.product.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.*;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "T_USER")
@SQLDelete(sql = "UPDATE T_USER SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends  Auditing{

    private static final long serialVersionUID = -3481225212971609086L;

    private String firstName;
    private String lastName;
    @NaturalId
    @Column(unique = true,nullable = false,updatable = false)
    @Email
    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        User other = (User) o;
        return Objects.equals(email, other.getEmail ()) ;
    }
}
