package com.stockmanagementsystem.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockmanagementsystem.server.models.Ventes;
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

    @JsonIgnore
    private List<LigneVenteDto> ligneVenteDtoList;

    public static VentesDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Ventes toEntity(VentesDto ventesDto) {
        if (ventesDto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(ventesDto.getCommentaire());
        return ventes;
    }
}
