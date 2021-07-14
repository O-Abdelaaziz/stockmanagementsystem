package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Created 12/07/2021 - 09:05
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
@Table(name = "ventes",schema = "public")
public class Ventes extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "date_vente")
    private Date dateVente;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "entreprise_id")
    private Long entrepriseId;

    @OneToMany(mappedBy = "ventes",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<LigneVente> ligneVenteList;
}
