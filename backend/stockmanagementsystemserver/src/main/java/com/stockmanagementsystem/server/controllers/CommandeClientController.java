package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.CommandeClientApi;
import com.stockmanagementsystem.server.dto.CommandeClientDto;
import com.stockmanagementsystem.server.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 25/07/2021 - 14:41
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class CommandeClientController implements CommandeClientApi {

    private CommandeClientService commandeClientService;

    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }


    @Override
    public ResponseEntity<List<CommandeClientDto>> findAll() {
        List<CommandeClientDto> commandeClientDtoList= commandeClientService.findAll();
        return new ResponseEntity<>(commandeClientDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Long id) {
        return new ResponseEntity<>(commandeClientService.findById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCode(String code) {
         return new ResponseEntity<>(commandeClientService.findByCode(code),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
        return new ResponseEntity<>(commandeClientService.save(commandeClientDto),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        commandeClientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }
}
