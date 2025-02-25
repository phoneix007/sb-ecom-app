package com.ecom.sb_ecom_application.service;

import com.ecom.sb_ecom_application.model.Product;
import com.ecom.sb_ecom_application.payload.ProductDTO;
import com.ecom.sb_ecom_application.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
    ProductResponse getProducts();
    ProductResponse getProductByCategory(Long categoryId);
    ProductResponse getProductByKeyword(String keyword);
}
