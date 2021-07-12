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
public class FournisseurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String photo;
    private String mail;
    private AdresseDto addressDto;
    private List<CommandeFournisseurDto> commandeFournisseurDtoList;
}
