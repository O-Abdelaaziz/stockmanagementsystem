package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;
import static com.stockmanagementsystem.server.controllers.constants.APIName.COMMANDE_FOURNISSEUR_PATH_VARIABLE_CODE;

/**
 * @Created 25/07/2021 - 15:04
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/

@Api("commande_fournisseur")
public interface CommandeFournisseurApi {
    @GetMapping(value =APP_ROOT +  COMMANDE_FOURNISSEUR, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CommandeFournisseurDto>> findAll();

    @ApiOperation(value = "Rechercher un commande_fournisseur par ID", notes = "Cette methode permet de chercher un commande_fournisseur par son ID", response = CommandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "commande_fournisseur a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun commande_fournisseur n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +COMMANDE_FOURNISSEUR +COMMANDE_FOURNISSEUR_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDto> findById(@PathVariable(COMMANDE_FOURNISSEUR_PATH_VARIABLE_CODE) Long id);


    @ApiOperation(value = "Rechercher un category par CODE", notes = "Cette methode permet de chercher un category par son CODE", response = CommandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun category n'existe dans la BDD avec le CODE fourni")
    })
    @GetMapping(value = APP_ROOT +COMMANDE_FOURNISSEUR +COMMANDE_FOURNISSEUR_PATH_CODE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDto> findByCode(@PathVariable(COMMANDE_FOURNISSEUR_PATH_VARIABLE_CODE) String code);

    @ApiOperation(value = "Enregistrer un commande_fournisseur", notes = "Cette methode permet d'enregistrer ou modifier un commande_fournisseur", response = CommandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet commande_fournisseur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet commande_fournisseur n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + COMMANDE_FOURNISSEUR, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto commandeClientDto);

    @ApiOperation(value = "Supprimer un commande_fournisseur", notes = "Cette methode permet de supprimer un commande_fournisseur par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "commande_fournisseur a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +COMMANDE_FOURNISSEUR +COMMANDE_FOURNISSEUR_PATH_ID)
    ResponseEntity<?> delete(@PathVariable(COMMANDE_FOURNISSEUR_PATH_VARIABLE_CODE) Long id);
}
