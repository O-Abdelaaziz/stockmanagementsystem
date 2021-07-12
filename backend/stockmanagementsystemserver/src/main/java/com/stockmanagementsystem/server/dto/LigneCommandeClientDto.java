package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.LigneCommandeClient;
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
public class LigneCommandeClientDto {
    private Long id;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private ArticleDto articleDto;
    private CommandeClientDto commandeClientDto;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .articleDto(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
        if (ligneCommandeClientDto == null) {
            return null;
        }

        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticleDto()));
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        return ligneCommandeClient;
    }
}
