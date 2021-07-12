package com.stockmanagementsystem.server.dto;

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
    private List<ArticleDto> articleDtoList;
}
