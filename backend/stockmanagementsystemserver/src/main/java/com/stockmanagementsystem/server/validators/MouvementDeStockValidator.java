package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.MouvementDeStockDto;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 12:37
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class MouvementDeStockValidator {

    public static List<String> validate(MouvementDeStockDto mouvementDeStockDto) {
        List<String> errors = new ArrayList<>();
        if (mouvementDeStockDto == null) {
            errors.add("Veuillez renseigner la date du mouvenent");
            errors.add("Veuillez renseigner la quantite du mouvenent");
            errors.add("Veuillez renseigner l'article");
            errors.add("Veuillez renseigner le type du mouvement");

            return errors;
        }
        if (mouvementDeStockDto.getDateMvt() == null) {
            errors.add("Veuillez renseigner la date du mouvenent");
        }
        if (mouvementDeStockDto.getQuantite() == null || mouvementDeStockDto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("Veuillez renseigner la quantite du mouvenent");
        }
        if (mouvementDeStockDto.getArticle() == null || mouvementDeStockDto.getArticle().getId() == null) {
            errors.add("Veuillez renseigner l'article");
        }
        if (!StringUtils.hasLength(mouvementDeStockDto.getTypeMvtStock().name())) {
            errors.add("Veuillez renseigner le type du mouvement");
        }

        return errors;
    }
}
