package com.ecom.sb_ecom_application.repositories;

import com.ecom.sb_ecom_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Category , Long> {

    Category findByCategoryName(String categoryName);
}
