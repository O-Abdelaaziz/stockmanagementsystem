package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.Roles;
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

    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateurDto()));
        return roles;
    }
}
