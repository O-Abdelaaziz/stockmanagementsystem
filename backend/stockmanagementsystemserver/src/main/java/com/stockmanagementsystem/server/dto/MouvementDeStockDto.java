package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.enums.MvtStockEnum;
import com.stockmanagementsystem.server.models.MouvementDeStock;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Created 12/07/2021 - 14:14
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class MouvementDeStockDto {
    private Long id;
    private Date dateMvt;
    private BigDecimal quantite;
    private MvtStockEnum typeMvtStock;
    private ArticleDto article;
    private Long entrepriseId;

    public static MouvementDeStockDto fromEntity(MouvementDeStock mouvementDeStock) {
        if (mouvementDeStock == null) {
            return null;
        }

        return MouvementDeStockDto.builder()
                .id(mouvementDeStock.getId())
                .dateMvt(mouvementDeStock.getDateMvt())
                .quantite(mouvementDeStock.getQuantite())
                .article(ArticleDto.fromEntity(mouvementDeStock.getArticle()))
                .typeMvtStock(mouvementDeStock.getTypeMvtStock())
                .entrepriseId(mouvementDeStock.getEntrepriseId())
                .build();
    }

    public static MouvementDeStock toEntity(MouvementDeStockDto dto) {
        if (dto == null) {
            return null;
        }

        MouvementDeStock mvtStk = new MouvementDeStock();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvtStock(dto.getTypeMvtStock());
        mvtStk.setEntrepriseId(dto.getEntrepriseId());
        return mvtStk;
    }
}
