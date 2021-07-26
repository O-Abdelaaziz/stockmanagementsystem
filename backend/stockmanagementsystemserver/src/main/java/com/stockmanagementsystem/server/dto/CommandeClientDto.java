package com.stockmanagementsystem.server.dto;

import com.stockmanagementsystem.server.models.CommandeClient;
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
public class CommandeClientDto {
    private Long id;
    private String code;
    private Date dateCommande;
    private ClientDto clientDto;
    private List<LigneCommandeClientDto> ligneCommandeClientDtoList;
    private Long entrepriseId;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .clientDto(ClientDto.fromEntity(commandeClient.getClient()))
                .entrepriseId(commandeClient.getEntrepriseId())
                .build();

    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClientDto()));
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setEntrepriseId(commandeClientDto.getEntrepriseId());
        return commandeClient;
    }
}
