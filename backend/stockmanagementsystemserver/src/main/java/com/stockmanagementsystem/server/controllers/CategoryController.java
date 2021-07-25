package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.CategoryApi;
import com.stockmanagementsystem.server.dto.CategoryDto;
import com.stockmanagementsystem.server.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 25/07/2021 - 13:50
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findCategoryByCode(String code) {
        return categoryService.findByCode(code);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public void delete(Long id) {
        categoryService.delete(id);
    }
}
