package com.stockmanagementsystem.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockmanagementsystem.server.models.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Created 12/07/2021 - 13:57
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class CategoryDto {
    private Long id;
    private String code;
    private String designation;
    @JsonIgnore
    private List<ArticleDto> articleDtoList;
    private Long entrepriseId;

    public static CategoryDto fromEntity(Category category){
        if(category == null){
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .entrepriseId(category.getEntrepriseId())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
        }

        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        category.setEntrepriseId(categoryDto.getEntrepriseId());

        return category;
    }
}
