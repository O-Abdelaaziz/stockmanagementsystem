package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Created 12/07/2021 - 09:05
 * @Package com.stockmanagementsystem.server.models
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lignes_commandes_fournisseurs",schema = "public")
public class LigneCommandeFournisseur extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "commande_fournisseur_id")
    private CommandeFournisseur commandeFournisseur;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;
}
