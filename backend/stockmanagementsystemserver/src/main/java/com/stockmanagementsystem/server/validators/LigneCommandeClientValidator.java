package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 12:25
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {
        List<String> errors = new ArrayList<>();
        if(ligneCommandeClientDto == null){
            errors.add("Veuillez renseigner la quantite");
            errors.add("Veuillez renseigner le prix unitaire");
            errors.add("Veuillez renseigner l'article");
            errors.add("Veuillez renseigner le commande client");
            return errors;
        }

        if (ligneCommandeClientDto.getQuantite()==null || ligneCommandeClientDto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("Veuillez renseigner la quantite");
        }
        if (ligneCommandeClientDto.getPrixUnitaire()==null) {
            errors.add("Veuillez renseigner le prix unitaire");
        }
        errors.addAll(ArticleValidator.validate(ligneCommandeClientDto.getArticleDto()));
        errors.addAll(CommandeClientValidator.validate(ligneCommandeClientDto.getCommandeClientDto()));

        return errors;
    }
}
