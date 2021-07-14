package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 11:39
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class ArticleValidator {

    public static List<String> validate (ArticleDto articleDto){
        List<String> errors=new ArrayList<>();
        if(articleDto == null){
            errors.add("Veuillez renseigner le code");
            errors.add("Veuillez renseigner le designation");
            errors.add("Veuillez renseigner le prixUnitaireHt");
            errors.add("Veuillez renseigner le prixUnitaireTtc");
            errors.add("Veuillez renseigner le tauxTva");
            errors.add("Veuillez renseigner le category");
            return errors;
        }

        if (!StringUtils.hasLength(articleDto.getCode())) {
            errors.add("Veuillez renseigner le code");
        }
        if (!StringUtils.hasLength(articleDto.getDesignation())) {
            errors.add("Veuillez renseigner le designation");
        }
        if (articleDto.getPrixUnitaireHt() == null) {
            errors.add("Veuillez renseigner le prixUnitaireHt");
        }
        if (articleDto.getPrixUnitaireTtc() == null) {
            errors.add("Veuillez renseigner le prixUnitaireTtc");
        }
        if (articleDto.getTauxTva() == null) {
            errors.add("Veuillez renseigner le tauxTva");
        }
        if (articleDto.getCategoryDto() == null) {
            errors.add("Veuillez renseigner le category");
        }
        return errors;
    }
}
