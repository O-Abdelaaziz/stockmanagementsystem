package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.LigneVenteDto;
import com.stockmanagementsystem.server.models.Ventes;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 12:42
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto ligneVenteDto) {
        List<String> errors = new ArrayList<>();
        if(ligneVenteDto == null){
            errors.add("Veuillez renseigner la quantite");
            errors.add("Veuillez renseigner le prix unitaire");
            errors.add("Veuillez renseigner les ventes");
            return errors;
        }

        if (ligneVenteDto.getQuantite()==null) {
            errors.add("Veuillez renseigner la quantite");
        }
        if (ligneVenteDto.getPrixUnitaire()==null) {
            errors.add("Veuillez renseigner le prix unitaire");
        }
        errors.addAll(VentesValidator.validate(ligneVenteDto.getVentesDto()));

        return errors;
    }
}
