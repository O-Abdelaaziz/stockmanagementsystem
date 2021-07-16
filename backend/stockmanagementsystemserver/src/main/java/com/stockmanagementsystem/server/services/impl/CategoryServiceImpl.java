package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.CategoryDto;
import com.stockmanagementsystem.server.repositories.CategoryRepository;
import com.stockmanagementsystem.server.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        return null;
    }

    @Override
    public CategoryDto findById(Long id) {
        return null;
    }

    @Override
    public CategoryDto findByCode(String code) {
        return null;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
