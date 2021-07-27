package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.dto.auth.AuthenticationRequest;
import com.stockmanagementsystem.server.dto.auth.AuthenticationResponse;
import com.stockmanagementsystem.server.models.auth.ExtendedUser;
import com.stockmanagementsystem.server.services.auth.CustomUserDetailsService;
import com.stockmanagementsystem.server.utilis.JwtUtils;
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
    private JwtUtils jwtUtils;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,CustomUserDetailsService customUserDetailsService,JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService=customUserDetailsService;
        this.jwtUtils=jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );

        final UserDetails userDetails=customUserDetailsService.loadUserByUsername(request.getEmail());
        final String jwt=jwtUtils.generateToken((ExtendedUser) userDetails);

        return  ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }
}
