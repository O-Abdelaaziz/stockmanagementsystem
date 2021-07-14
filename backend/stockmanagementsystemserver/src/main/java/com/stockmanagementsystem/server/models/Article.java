package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Created 12/07/2021 - 09:03
 * @Package com.stockmanagementsystem.server.models
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles",schema = "public")
public class Article extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prix_unitaire_ht")
    private BigDecimal prixUnitaireHt;

    @Column(name = "prix_unitaire_ttc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "taux_tva")
    private BigDecimal tauxTva;

    @Column(name = "photo")
    private String photo;

    @Column(name = "entreprise_id")
    private Long entrepriseId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "article",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<LigneCommandeClient> ligneCommandeClientList;

    @OneToMany(mappedBy = "article",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurList;

    @OneToMany(mappedBy = "article",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<MouvementDeStock> mouvementDeStockList;
}
