package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
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
@Table(name = "commandes_clients",schema = "public")
public class CommandeClient extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    @Column(name ="date_commande")
    private Date dateCommande;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commandeClient",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<LigneCommandeClient> ligneCommandeClientList;
}
