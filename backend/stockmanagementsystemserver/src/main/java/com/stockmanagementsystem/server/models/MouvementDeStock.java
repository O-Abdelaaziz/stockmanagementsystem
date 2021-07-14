package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.enums.MvtStockEnum;
import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Created 12/07/2021 - 09:08
 * @Package com.stockmanagementsystem.server.models
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mouvements_de_stock",schema = "public")
public class MouvementDeStock extends AbstractEntity {

    @Column(name = "date_Mvt")
    private Date dateMvt;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "type_mvt_stock")
    private MvtStockEnum typeMvtStock;

    @Column(name = "entreprise_id")
    private Long entrepriseId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;
}
