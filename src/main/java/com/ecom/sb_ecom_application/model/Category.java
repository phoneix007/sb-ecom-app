package com.ecom.sb_ecom_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    Long categoryId;

    @NotBlank
    String categoryName;
}
