package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Created 12/07/2021 - 09:04
 * @Package com.stockmanagementsystem.server.models
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commandes_fournisseurs",schema = "public")
public class CommandeFournisseur extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    @Column(name ="date_commande")
    private Date dateCommande;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
}
