package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;
import static com.stockmanagementsystem.server.controllers.constants.APIName.CLIENT_PATH_VARIABLE_ID;

/**
 * @Created 25/07/2021 - 13:57
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("clients")
public interface ClientApi {

    @GetMapping(value =APP_ROOT +  CLIENT, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @ApiOperation(value = "Rechercher un client par ID", notes = "Cette methode permet de chercher un client par son ID", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "client a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun client n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +CLIENT +CLIENT_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable(CLIENT_PATH_VARIABLE_ID) Long id);

    @ApiOperation(value = "Enregistrer un client", notes = "Cette methode permet d'enregistrer ou modifier un client", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet client n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + CLIENT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);

    @ApiOperation(value = "Supprimer un client", notes = "Cette methode permet de supprimer un client par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "client a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +CLIENT +CLIENT_PATH_ID)
    void delete(@PathVariable(CLIENT_PATH_VARIABLE_ID) Long id);
}
