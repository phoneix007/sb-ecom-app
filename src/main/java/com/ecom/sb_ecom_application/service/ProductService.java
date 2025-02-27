package com.ecom.sb_ecom_application.service;

import com.ecom.sb_ecom_application.model.Product;
import com.ecom.sb_ecom_application.payload.ProductDTO;
import com.ecom.sb_ecom_application.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
    ProductResponse getProducts();
    ProductResponse getProductByCategory(Long categoryId);
    ProductResponse getProductByKeyword(String keyword);
    ProductDTO updateProduct(Long productId, Product product);
    String deleteProduct(Long productId);

    ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
