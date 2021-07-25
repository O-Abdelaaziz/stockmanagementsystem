package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.CommandeFournisseurApi;
import com.stockmanagementsystem.server.dto.CommandeFournisseurDto;
import com.stockmanagementsystem.server.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 25/07/2021 - 15:12
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService;

    @Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public ResponseEntity<List<CommandeFournisseurDto>> findAll() {
        List<CommandeFournisseurDto> commandeFournisseurDtoList=commandeFournisseurService.findAll();
        return new ResponseEntity<>(commandeFournisseurDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findById(Long id) {
        return new ResponseEntity<>(commandeFournisseurService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findByCode(String code) {
        return new ResponseEntity<>(commandeFournisseurService.findByCode(code), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> save(CommandeFournisseurDto commandeClientDto) {
        return new ResponseEntity<>(commandeFournisseurService.save(commandeClientDto), HttpStatus.CREATED);;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        commandeFournisseurService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
