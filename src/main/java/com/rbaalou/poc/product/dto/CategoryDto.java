package com.rbaalou.poc.product.dto;

import com.rbaalou.poc.product.dao.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Category}
 */
public record CategoryDto(@NotNull Category.CategoryType type,
                          @NotBlank String name,
                          @NotBlank String description,
                          @NotNull Set<ProductDto> products) implements Serializable {
  private static final long serialVersionUID = -3037922050955755622L;
}
