package com.ecom.sb_ecom_application.controller;

import com.ecom.sb_ecom_application.model.Product;
import com.ecom.sb_ecom_application.payload.ProductDTO;
import com.ecom.sb_ecom_application.payload.ProductResponse;
import com.ecom.sb_ecom_application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product,
                                                 @PathVariable Long categoryId){
        ProductDTO productDTO = productService.addProduct(categoryId, product);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse> getAllProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/public/category/{categoryId}/products")
    public ResponseEntity<ProductResponse> getAllProductsByCategory(@PathVariable Long categoryId){
        return new ResponseEntity<>(productService.getProductByCategory(categoryId), HttpStatus.OK);
    }
    @GetMapping("/public/products/{keyword}")
    public ResponseEntity<ProductResponse> getAllProductsByCategory(@PathVariable String keyword ){
        return new ResponseEntity<>(productService.getProductByKeyword(keyword), HttpStatus.FOUND);
    }
}
