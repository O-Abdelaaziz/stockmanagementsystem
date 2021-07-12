package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created 12/07/2021 - 14:14
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class UtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String email;
    private String moteDePasse;
    private String photo;
    private AdresseDto adresseDto;
    private EntrepriseDto entrepriseDto;
    private List<RolesDto> rolesDtoList;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .moteDePasse(utilisateur.getMoteDePasse())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .adresseDto(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .entrepriseDto(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .rolesDtoList(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMoteDePasse(dto.getMoteDePasse());
        utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
        utilisateur.setAdresse(AdresseDto.toEntity(dto.getAdresseDto()));
        utilisateur.setPhoto(dto.getPhoto());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(dto.getEntrepriseDto()));

        return utilisateur;
    }
}
