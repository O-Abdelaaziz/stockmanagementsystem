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
public class VentesDto {
    private Long id;
    private String code;
    private Date dateVente;
    private String commentaire;
    private List<LigneVenteDto> ligneVenteDtoList;
}
