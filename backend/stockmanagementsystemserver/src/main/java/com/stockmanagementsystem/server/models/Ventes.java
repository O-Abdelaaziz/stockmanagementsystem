package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
@Table(name = "ventes",schema = "public")
public class Ventes extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "ventes",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<LigneVente> ligneVenteList;
}
