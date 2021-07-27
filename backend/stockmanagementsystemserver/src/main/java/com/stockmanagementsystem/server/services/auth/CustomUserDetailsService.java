package com.stockmanagementsystem.server.services.auth;

import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.models.Utilisateur;
import com.stockmanagementsystem.server.models.auth.ExtendedUser;
import com.stockmanagementsystem.server.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Created 26/07/2021 - 10:29
 * @Package com.stockmanagementsystem.server.services.auth
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur=utilisateurRepository.findByEmail(email);
        if(utilisateur ==null){
            throw new EntityNotFoundException("user not found with email: " + email, ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        List<SimpleGrantedAuthority> authorityList=new ArrayList<>();
        utilisateur.getRoles().forEach(
                roles -> {
                    authorityList.add(new SimpleGrantedAuthority(roles.getRoleName()));
                }
        );
        return new ExtendedUser(utilisateur.getEmail(),utilisateur.getMoteDePasse(), utilisateur.getEntreprise().getId(),authorityList);
    }
}
