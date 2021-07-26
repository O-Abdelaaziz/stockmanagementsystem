package com.stockmanagementsystem.server.dto.auth;

import lombok.Builder;
import lombok.Data;

/**
 * @Created 26/07/2021 - 10:24
 * @Package com.stockmanagementsystem.server.dto.auth
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@Builder
public class AuthenticationRequest {

    private String email;
    private String password;
}
