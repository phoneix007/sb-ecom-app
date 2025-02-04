package com.ecom.sb_ecom_application.controller;

import com.ecom.sb_ecom_application.config.AppConstants;
import com.ecom.sb_ecom_application.model.Category;
import com.ecom.sb_ecom_application.payload.CategoryDTO;
import com.ecom.sb_ecom_application.payload.CategoryResponse;
import com.ecom.sb_ecom_application.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategroyController {

    private final CategoryService categoryService;

    public CategroyController(CategoryService categoryService ){
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public CategoryResponse getCategories(
            @RequestParam (name = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER , required = false) Integer pageNumber ,
            @RequestParam (name = "pageSize" , defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize ,
            @RequestParam (name = "sortBy", defaultValue = AppConstants.SORT_CATEGORY_BY , required = false) String sortBy ,
            @RequestParam (name ="sortOrder" , defaultValue = AppConstants.SORT_ORDER , required = false) String sortOrder){
        return categoryService.getCategories(pageNumber , pageSize, sortBy , sortOrder);
    }

    @PostMapping("/api/public/categories")
    public  ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO category){
         CategoryDTO cat = categoryService.createCategory(category);
         return new ResponseEntity<CategoryDTO>(cat , HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{id}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable long id){
            CategoryDTO deleteCategory  = categoryService.deleteCategory(id);
            return new ResponseEntity<>(deleteCategory , HttpStatus.OK);

    }
    @PutMapping("/api/admin/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable long id , @Valid @RequestBody CategoryDTO category){

            CategoryDTO updatedCategory  = categoryService.updateCategory(id , category);
            return new ResponseEntity<>(updatedCategory , HttpStatus.OK);

    }
}
