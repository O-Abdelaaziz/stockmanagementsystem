package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.Entreprise;
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
public class EntrepriseDto {
    private Long id;
    private String nom;
    private String description;
    private AdresseDto adresseDto;
    private String codeFiscal;
    private String photo;
    private String email;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurDtoList;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresseDto(AdresseDto.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresseDto()));
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());

        return entreprise;
    }
}
