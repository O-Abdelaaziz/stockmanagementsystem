package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.FournisseurApi;
import com.stockmanagementsystem.server.dto.FournisseurDto;
import com.stockmanagementsystem.server.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 25/07/2021 - 14:23
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public ResponseEntity<List<FournisseurDto>> findAll() {
        List<FournisseurDto> fournisseurDtoList= fournisseurService.findAll();
        return new ResponseEntity<>(fournisseurDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FournisseurDto> findById(Long id) {
        return new ResponseEntity<>(fournisseurService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FournisseurDto> save(FournisseurDto fournisseurDto) {
        return new ResponseEntity<>(fournisseurService.save(fournisseurDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        fournisseurService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
