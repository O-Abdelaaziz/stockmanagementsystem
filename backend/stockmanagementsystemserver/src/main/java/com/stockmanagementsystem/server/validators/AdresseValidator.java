package com.stockmanagementsystem.server.validators;

import com.stockmanagementsystem.server.dto.AdresseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created 13/07/2021 - 09:08
 * @Package com.stockmanagementsystem.server.validators
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class AdresseValidator {

    public static List<String> validate (AdresseDto adresseDto){
        List<String> errors=new ArrayList<>();
        if(adresseDto == null){
            errors.add("Veuillez renseigner la pays");
            errors.add("Veuillez renseigner la adresse");
            errors.add("Veuillez renseigner le ville");
            errors.add("Veuillez renseigner l'etat");
            errors.add("Veuillez renseigner le code postal");
            errors.add("Veuillez renseigner le telephone fixe");
            errors.add("Veuillez renseigner le telephone mobile 1");
            errors.add("Veuillez renseigner le telephone mobile 2");
            errors.add("Veuillez renseigner le numero de fax");
            return errors;
        }

        if (!StringUtils.hasLength(adresseDto.getCountry())) {
            errors.add("Veuillez renseigner la pays");
        }
        if (!StringUtils.hasLength(adresseDto.getAdresse())) {
            errors.add("Veuillez renseigner la adresse");
        }
        if (!StringUtils.hasLength(adresseDto.getVille())) {
            errors.add("Veuillez renseigner le ville");
        }
        if (!StringUtils.hasLength(adresseDto.getEtat())) {
            errors.add("Veuillez renseigner l'etat");
        }
        if (!StringUtils.hasLength(adresseDto.getCodePostal())) {
            errors.add("Veuillez renseigner le code postal");
        }
        if (!StringUtils.hasLength(adresseDto.getTelephoneFixe())) {
            errors.add("Veuillez renseigner le telephone fixe");
        }
        if (!StringUtils.hasLength(adresseDto.getTelephoneMobile1())) {
            errors.add("Veuillez renseigner le telephone mobile 1");
        }
        if (!StringUtils.hasLength(adresseDto.getTelephoneMobile2())) {
            errors.add("Veuillez renseigner le telephone mobile 2");
        }
        if (!StringUtils.hasLength(adresseDto.getNumeroDeFax())) {
            errors.add("Veuillez renseigner le numero de fax");
        }
        return errors;
    }
}
