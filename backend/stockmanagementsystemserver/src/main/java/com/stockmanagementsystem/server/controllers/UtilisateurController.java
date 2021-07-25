package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.UtilisateurApi;
import com.stockmanagementsystem.server.dto.UtilisateurDto;
import com.stockmanagementsystem.server.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 25/07/2021 - 15:02
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class UtilisateurController implements UtilisateurApi{

    private UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public ResponseEntity<List<UtilisateurDto>> findAll() {
        List<UtilisateurDto> utilisateurDtoList=utilisateurService.findAll();
        return new ResponseEntity<>(utilisateurDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UtilisateurDto> findById(Long id) {
        return new ResponseEntity<>(utilisateurService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UtilisateurDto> save(UtilisateurDto utilisateurDto) {
        return new ResponseEntity<>(utilisateurService.save(utilisateurDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        utilisateurService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
