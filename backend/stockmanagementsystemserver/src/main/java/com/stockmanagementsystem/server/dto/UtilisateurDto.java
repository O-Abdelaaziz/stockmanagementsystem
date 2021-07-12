package com.stockmanagementsystem.server.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Created 12/07/2021 - 14:14
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class UtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String email;
    private String moteDePasse;
    private String photo;
    private AdresseDto adresseDto;
    private EnterpriseDto enterpriseDto;
    private List<RolesDto> rolesDtoList;
}
