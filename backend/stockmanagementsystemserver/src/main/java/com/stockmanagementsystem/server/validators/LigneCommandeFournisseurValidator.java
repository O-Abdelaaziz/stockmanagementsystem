package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.LigneCommandeFournisseurDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 12:32
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        List<String> errors = new ArrayList<>();
        if(ligneCommandeFournisseurDto == null){
            errors.add("Veuillez renseigner la quantite");
            errors.add("Veuillez renseigner le prix unitaire");
            errors.add("Veuillez renseigner l'article");
            errors.add("Veuillez renseigner le commande client");
            return errors;
        }

        if (ligneCommandeFournisseurDto.getQuantite()==null || ligneCommandeFournisseurDto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("Veuillez renseigner la quantite");
        }
        if (ligneCommandeFournisseurDto.getPrixUnitaire()==null) {
            errors.add("Veuillez renseigner le prix unitaire");
        }
        errors.addAll(ArticleValidator.validate(ligneCommandeFournisseurDto.getArticleDto()));
        errors.addAll(CommandeFournisseurValidator.validate(ligneCommandeFournisseurDto.getCommandeFournisseurDto()));

        return errors;
    }
}
