package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Created 12/07/2021 - 14:13
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class FournisseurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String photo;
    private String mail;
    private AdresseDto addressDto;
    private List<CommandeFournisseurDto> commandeFournisseurDtoList;
    private Long entrepriseId;

    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .addressDto(AdresseDto.fromEntity(fournisseur.getAddress()))
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .entrepriseId(fournisseur.getEntrepriseId())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAddress(AdresseDto.toEntity(fournisseurDto.getAddressDto()));
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setEntrepriseId(fournisseurDto.getEntrepriseId());

        return fournisseur;
    }
}
