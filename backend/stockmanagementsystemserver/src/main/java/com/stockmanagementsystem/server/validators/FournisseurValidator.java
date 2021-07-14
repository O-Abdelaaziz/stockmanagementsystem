package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created 14/07/2021 - 11:56
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class FournisseurValidator {

    public static List<String> validate (FournisseurDto fournisseurDto){
        List<String> errors=new ArrayList<>();

        if(fournisseurDto == null){
            errors.add("Veuillez renseigner le nom");
            errors.add("Veuillez renseigner le prenom");
            errors.add("Veuillez renseigner l'email");
            errors.add("Veuillez renseigner l'address");
            return errors;
        }

        if (!StringUtils.hasLength(fournisseurDto.getNom())) {
            errors.add("Veuillez renseigner la nom");
        }
        if (!StringUtils.hasLength(fournisseurDto.getPrenom())) {
            errors.add("Veuillez renseigner la prenom");
        }
        if (!StringUtils.hasLength(fournisseurDto.getMail())) {
            errors.add("Veuillez renseigner l'email");
        }
        if (fournisseurDto.getAddressDto()== null) {
            errors.add("Veuillez renseigner l'address");
        }

        return errors;
    }
}
