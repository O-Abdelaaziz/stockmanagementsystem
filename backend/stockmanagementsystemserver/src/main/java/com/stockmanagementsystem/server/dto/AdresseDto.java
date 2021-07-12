package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.Adresse;
import lombok.Builder;
import lombok.Data;

/**
 * @Created 12/07/2021 - 14:12
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@Builder
public class AdresseDto {

    private String country;
    private String adresse;
    private String ville;
    private String etat;
    private String codePostal;
    private String telephoneFixe;
    private String telephoneMobile1;
    private String telephoneMobile2;
    private String numeroDeFax;

    public static AdresseDto fromEntity(Adresse adresse){
        if(adresse == null){
            return null;
        }

        return AdresseDto.builder()
                .country(adresse.getCountry())
                .adresse(adresse.getAdresse())
                .ville(adresse.getVille())
                .etat(adresse.getEtat())
                .codePostal(adresse.getCodePostal())
                .telephoneFixe(adresse.getTelephoneFixe())
                .telephoneMobile1(adresse.getTelephoneMobile1())
                .telephoneMobile2(adresse.getTelephoneMobile2())
                .numeroDeFax(adresse.getNumeroDeFax()).build();
    }

    public static Adresse toEntity(AdresseDto adresseDto){
        if(adresseDto==null){
            return null;
        }

        Adresse adresse=new Adresse();
        adresse.setCountry(adresseDto.getCountry());
        adresse.setAdresse(adresseDto.getAdresse());
        adresse.setVille(adresseDto.getVille());
        adresse.setEtat(adresseDto.getEtat());
        adresse.setCodePostal(adresseDto.getCodePostal());
        adresse.setTelephoneFixe(adresseDto.getTelephoneFixe());
        adresse.setTelephoneMobile1(adresseDto.getTelephoneMobile1());
        adresse.setTelephoneMobile2(adresseDto.getTelephoneMobile2());
        adresse.setNumeroDeFax(adresseDto.getNumeroDeFax());
        return adresse;
    }
}
