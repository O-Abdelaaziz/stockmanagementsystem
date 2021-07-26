package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.dto.auth.AuthenticationRequest;
import com.stockmanagementsystem.server.dto.auth.AuthenticationResponse;
import com.stockmanagementsystem.server.services.auth.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.stockmanagementsystem.server.controllers.constants.APIName.AUTHENTICATE;

/**
 * @Created 26/07/2021 - 10:46
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
@RequestMapping(AUTHENTICATE)
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService=customUserDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );

        final UserDetails userDetails=customUserDetailsService.loadUserByUsername(request.getEmail());

        return  ResponseEntity.ok(AuthenticationResponse.builder().accessToken("default_access_token").build());
    }
}
