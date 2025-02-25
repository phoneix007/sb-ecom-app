package com.ecom.sb_ecom_application.repositories;

import com.ecom.sb_ecom_application.model.Category;
import com.ecom.sb_ecom_application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategoryOrderByPriceAsc(Category category);

    List<Product> findByProductNameLikeIgnoreCase(String Keyword);
}
