package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.VentesApi;
import com.stockmanagementsystem.server.dto.VentesDto;
import com.stockmanagementsystem.server.services.VentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 25/07/2021 - 14:52
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class VentesController implements VentesApi {

    private VentesService ventesService;

    @Autowired
    public VentesController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Override
    public ResponseEntity<List<VentesDto>> findAll() {
        List<VentesDto> ventesDtoList=ventesService.findAll();
        return new ResponseEntity<>(ventesDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VentesDto> findById(Long id) {
        return new ResponseEntity<>(ventesService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VentesDto> findByCode(String code) {
        return new ResponseEntity<>(ventesService.findByCode(code), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VentesDto> save(VentesDto ventesDto) {
        return new ResponseEntity<>(ventesService.save(ventesDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        ventesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
