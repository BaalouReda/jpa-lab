package com.rbaalou.poc.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.rbaalou.poc.product.dao.Product}
 */
public record ProductDto(@NotBlank String materialNumber,
                         @NotBlank String name,
                         @NotBlank String description,
                         @NotNull Double price,
                         @NotNull CustomerDto customer,
                         @NotNull CategoryDto category) implements Serializable {
  private static final long serialVersionUID = -3037922050955755622L;
}
