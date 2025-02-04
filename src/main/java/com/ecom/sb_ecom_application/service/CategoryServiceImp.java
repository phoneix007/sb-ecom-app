package com.ecom.sb_ecom_application.service;

import com.ecom.sb_ecom_application.exception.APIException;
import com.ecom.sb_ecom_application.exception.ResourceNotFoundException;
import com.ecom.sb_ecom_application.model.Category;
import com.ecom.sb_ecom_application.payload.CategoryDTO;
import com.ecom.sb_ecom_application.payload.CategoryResponse;
import com.ecom.sb_ecom_application.repositories.CategoriesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp  implements CategoryService{
    long id = 1L;
    @Autowired
    CategoriesRepo catRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryResponse getCategories(Integer pageNumber , Integer pageSize , String sortBy , String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize , sortByAndOrder);
        Page<Category> categoryPage = catRepo.findAll(pageable);
        List<Category> categoryList = categoryPage.getContent();
        List<CategoryDTO> categoryDTOs = categoryList.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOs);
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setTotalElements(categoryPage.getNumberOfElements());
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setLastPage(categoryPage.isLast());
        return categoryResponse;
    }

    @Override
    public CategoryDTO deleteCategory(long id) {
        Category cat = catRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryName", id));
        catRepo.delete(cat);
        return modelMapper.map(cat, CategoryDTO.class);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO category) {
        Category cat = modelMapper.map(category, Category.class);
         Category temp = catRepo.findByCategoryName(category.getCategoryName());
        if(temp != null){
            throw new APIException("Category with that category name already exists");
        }
        cat.setCategoryId(id++);
        Category saveCategory = catRepo.save(cat);
        return modelMapper.map(saveCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(long id , CategoryDTO category) {
        Category temp = modelMapper.map(category, Category.class);
        Category cat =  catRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryName", id));
        cat.setCategoryName(temp.getCategoryName());
        catRepo.save(cat);
        return modelMapper.map(cat, CategoryDTO.class);
    }
}
