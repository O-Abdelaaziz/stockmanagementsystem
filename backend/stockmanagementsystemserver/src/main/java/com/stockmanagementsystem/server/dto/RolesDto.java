package com.stockmanagementsystem.server.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Created 12/07/2021 - 14:14
 * @Package com.stockmanagementsystem.server.dto
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Builder
@Data
public class RolesDto {
    private Long id;
    private String roleName;
    private UtilisateurDto utilisateurDto;
}
