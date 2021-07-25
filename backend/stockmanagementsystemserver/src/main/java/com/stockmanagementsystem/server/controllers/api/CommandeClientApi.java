package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.CategoryDto;
import com.stockmanagementsystem.server.dto.ClientDto;
import com.stockmanagementsystem.server.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;

/**
 * @Created 25/07/2021 - 14:39
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("commande_client")
public interface CommandeClientApi {

    @GetMapping(value =APP_ROOT +  COMMANDE_CLIENT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CommandeClientDto>> findAll();

    @ApiOperation(value = "Rechercher un commande_client par ID", notes = "Cette methode permet de chercher un commande_client par son ID", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "commande_client a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun commande_client n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +COMMANDE_CLIENT +COMMANDE_CLIENT_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findById(@PathVariable(COMMANDE_CLIENT_PATH_VARIABLE_CODE) Long id);


    @ApiOperation(value = "Rechercher un category par CODE", notes = "Cette methode permet de chercher un category par son CODE", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun category n'existe dans la BDD avec le CODE fourni")
    })
    @GetMapping(value = APP_ROOT +COMMANDE_CLIENT +COMMANDE_CLIENT_PATH_CODE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable(COMMANDE_CLIENT_PATH_VARIABLE_CODE) String code);

    @ApiOperation(value = "Enregistrer un commande_client", notes = "Cette methode permet d'enregistrer ou modifier un commande_client", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet commande_client cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet commande_client n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + COMMANDE_CLIENT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);

    @ApiOperation(value = "Supprimer un commande_client", notes = "Cette methode permet de supprimer un commande_client par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "commande_client a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +COMMANDE_CLIENT +COMMANDE_CLIENT_PATH_ID)
    ResponseEntity<?> delete(@PathVariable(COMMANDE_CLIENT_PATH_VARIABLE_CODE) Long id);
}
