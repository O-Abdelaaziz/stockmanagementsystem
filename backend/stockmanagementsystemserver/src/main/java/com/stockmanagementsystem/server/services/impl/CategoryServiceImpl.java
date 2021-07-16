package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.CategoryDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.Category;
import com.stockmanagementsystem.server.repositories.CategoryRepository;
import com.stockmanagementsystem.server.services.CategoryService;
import com.stockmanagementsystem.server.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        if(id==null){
            log.error("-_=> CategoryServiceImpl(43) => findById: Article id is null {}",id);
            return null;
        }
        Optional<Category> category=categoryRepository.findById(id);
        CategoryDto categoryDto=CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(()-> new EntityNotFoundException("CategoryServiceImpl(45) => findById: no category found with id: "+id, ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("-_=> findByCode(54) => findByCode: Article code is null {}",code);
            return null;
        }
        Optional<Category> category=categoryRepository.findByCode(code);
        CategoryDto categoryDto=CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(()-> new EntityNotFoundException("CategoryServiceImpl(59) => findByCode: no category found with code: "+code,ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors= CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("-_=> CategoryServiceImpl(66) => save: category not valid {}",categoryDto);
            throw new InvalidEntityException("category not valid", ErrorCodes.ARTICLE_NOT_VALID);
        }
        Category newCategory=categoryRepository.save(CategoryDto.toEntity(categoryDto));
        CategoryDto newCategoryDto=CategoryDto.fromEntity(newCategory);
        return newCategoryDto;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("-_=> CategoryServiceImpl(82) => delete: category id is null {}",id);
            return;
        }
        CategoryDto categoryDto=findById(id);
        Category category=CategoryDto.toEntity(categoryDto);
        categoryRepository.delete(category);
    }
}
