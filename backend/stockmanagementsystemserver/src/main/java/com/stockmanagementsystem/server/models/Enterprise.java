package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
@Table(name = "enterprises",schema = "public")
public class Enterprise extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Embedded
    private Adresse adresse;

    @Column(name = "code_fiscal")
    private String codeFiscal;

    @Column(name = photo)
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "site_web")
    private String siteWeb;

    @OneToMany(mappedBy = "enterprise",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Utilisateur> utilisateurList;
}
