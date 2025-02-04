package com.ecom.sb_ecom_application.service;

import com.ecom.sb_ecom_application.model.Category;
import com.ecom.sb_ecom_application.payload.CategoryDTO;
import com.ecom.sb_ecom_application.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getCategories(Integer PageNumber ,Integer pageSize , String sortBy , String sortOrder);
    CategoryDTO  deleteCategory(long id);
    CategoryDTO createCategory(CategoryDTO category);
    CategoryDTO updateCategory(long id , CategoryDTO category);
}
