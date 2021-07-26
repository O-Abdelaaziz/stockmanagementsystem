package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Created 12/07/2021 - 14:13
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class LigneCommandeFournisseurDto {
    private Long id;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private ArticleDto articleDto;
    private CommandeFournisseurDto commandeFournisseurDto;
    private Long entrepriseId;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null) {
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .articleDto(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .entrepriseId(ligneCommandeFournisseur.getEntrepriseId())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        if (ligneCommandeFournisseurDto == null) {
            return null;
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticleDto()));
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
        ligneCommandeFournisseur.setEntrepriseId(ligneCommandeFournisseurDto.getEntrepriseId());
        return ligneCommandeFournisseur;
    }
}
