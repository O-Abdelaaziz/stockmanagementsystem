package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.LigneVente;
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
public class LigneVenteDto {
    private Long id;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private VentesDto ventesDto;
    private ArticleDto articleDto;
    private Long entrepriseId;

    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .ventesDto(VentesDto.fromEntity(ligneVente.getVentes()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .entrepriseId(ligneVente.getEntrepriseId())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setVentes(VentesDto.toEntity(ligneVenteDto.getVentesDto()));
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setEntrepriseId(ligneVenteDto.getEntrepriseId());
        return ligneVente;
    }
}
