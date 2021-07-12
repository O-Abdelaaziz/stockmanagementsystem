package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Created 12/07/2021 - 09:09
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
@Table(name = "utilisateur",schema = "public")
public class Utilisateur extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private Date dateDeNaissance;

    @Column(name = "email")
    private String email;

    @Column(name = "mote_de_passe")
    private String moteDePasse;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprise_id")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.EAGER)
    private List<Roles> roles;
}
