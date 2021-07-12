package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.enums.MvtStockEnum;
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
}
