package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    CategoryDto findByCode(String code);
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(CategoryDto categoryDto ,Long id);
    void  delete(Long id);
}
