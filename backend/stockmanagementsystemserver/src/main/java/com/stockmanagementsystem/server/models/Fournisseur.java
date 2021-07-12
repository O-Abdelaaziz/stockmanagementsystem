package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @Created 12/07/2021 - 09:04
 * @Package com.stockmanagementsystem.server.models
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fournisseurs",schema = "public")
public class Fournisseur extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mail")
    private String mail;

    @Embedded
    private Adresse address;

    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<CommandeFournisseur> commandeFournisseurList;
}
