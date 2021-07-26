package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.Article;
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
    private Long entrepriseId;

    public static ArticleDto fromEntity(Article article){
        if(article==null){
            return null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .code(article.getCode())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .tauxTva(article.getTauxTva())
                .photo(article.getPhoto())
                .categoryDto(CategoryDto.fromEntity(article.getCategory()))
                .entrepriseId(article.getEntrepriseId())
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto==null){
            return null;
        }

        Article article=new Article();
        article.setId(articleDto.getId());
        article.setCode(articleDto.getCode());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategoryDto()));
        article.setEntrepriseId(articleDto.getEntrepriseId());

        return article;
    }
}
