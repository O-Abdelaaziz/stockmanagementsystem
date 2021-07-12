package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Created 12/07/2021 - 09:55
 * @Package com.stockmanagementsystem.server.models
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Entity
@Table(name = "adresses",schema = "public")
public class Adresse extends AbstractEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "adresse_1")
    private String adresse1;

    @Column(name = "ville")
    private String ville;

    @Column(name = "etat")
    private String etat;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "telephone_fixe")
    private String telephoneFixe;

    @Column(name = "telephone_mobile_1")
    private String telephoneMobile1;

    @Column(name = "telephone_mobile_2")
    private String telephoneMobile2;

    @Column(name = "numero_de_fax")
    private String numeroDeFax;
}
