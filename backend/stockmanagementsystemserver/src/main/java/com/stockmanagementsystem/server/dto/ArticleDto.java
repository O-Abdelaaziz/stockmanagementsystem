package com.stockmanagementsystem.server.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @Created 12/07/2021 - 13:54
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class ArticleDto {
    private Long id;
    private String code;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal prixUnitaireTtc;
    private BigDecimal tauxTva;
    private String photo;
    private CategoryDto categoryDto;
}
