package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.EntrepriseApi;
import com.stockmanagementsystem.server.dto.EntrepriseDto;
import com.stockmanagementsystem.server.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 25/07/2021 - 14:38
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public ResponseEntity<List<EntrepriseDto>> findAll() {
        List<EntrepriseDto> entrepriseDtoList=entrepriseService.findAll();
        return new ResponseEntity<>(entrepriseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntrepriseDto> findById(Long id) {
        return new ResponseEntity<>(entrepriseService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntrepriseDto> save(EntrepriseDto entrepriseDto) {
        return new ResponseEntity<>(entrepriseService.save(entrepriseDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        entrepriseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
