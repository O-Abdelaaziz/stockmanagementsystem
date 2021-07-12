package com.stockmanagementsystem.server.dto;

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
}
