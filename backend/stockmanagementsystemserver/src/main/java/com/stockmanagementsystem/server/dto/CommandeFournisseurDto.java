package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.Fournisseur;
import com.stockmanagementsystem.server.models.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Created 12/07/2021 - 14:12
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class CommandeFournisseurDto {
    private Long id;
    private String code;
    private Date dateCommande;
    private FournisseurDto fournisseurDto;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtoList;
}
