package com.rbaalou.poc.product.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.rbaalou.poc.product.dao.Customer}
 */
public record CustomerDto(@NotBlank String firstName,
                          @NotBlank String lastName,
                          @NotNull @Email String email) implements Serializable {
  private static final long serialVersionUID = -3037922050955755622L;
  }
