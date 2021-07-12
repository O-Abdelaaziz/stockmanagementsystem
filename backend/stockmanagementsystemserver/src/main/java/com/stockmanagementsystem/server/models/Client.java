package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "clients",schema = "public")
public class Client extends AbstractEntity {

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

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<CommandeClient> commandeClientList;
}
