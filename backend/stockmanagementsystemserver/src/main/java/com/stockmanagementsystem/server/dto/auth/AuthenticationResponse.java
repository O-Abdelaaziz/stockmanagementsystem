package com.stockmanagementsystem.server.dto.auth;

import lombok.Builder;
import lombok.Data;

/**
 * @Created 26/07/2021 - 10:25
 * @Package com.stockmanagementsystem.server.dto.auth
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private String nom;
    private String prenom;
    private String email;
    private String photo;
}
