package com.stockmanagementsystem.server.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Created 12/07/2021 - 14:13
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class EnterpriseDto {
    private Long id;
    private String nom;
    private String description;
    private AdresseDto adresseDto;
    private String codeFiscal;
    private String photo;
    private String email;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurDtoList;
}
