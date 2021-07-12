package com.stockmanagementsystem.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockmanagementsystem.server.models.Client;
import lombok.Builder;
import lombok.Data;

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
public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String photo;
    private String email;
    private AdresseDto address;

    @JsonIgnore
    private List<CommandeClientDto> commandeClientDtoList;

    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .email(client.getEmail())
                .address(AdresseDto.fromEntity(client.getAddress())).build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
        }

        Client client=new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setEmail(clientDto.getEmail());
        client.setAddress(AdresseDto.toEntity(clientDto.getAddress()));
        return client;
    }
}
