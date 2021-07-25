package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.FournisseurDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;
import static com.stockmanagementsystem.server.controllers.constants.APIName.FOURNISSEUR_PATH_VARIABLE_ID;

/**
 * @Created 25/07/2021 - 15:19
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("fournisseurs")
public interface FournisseurApi {

    @GetMapping(value =APP_ROOT +  FOURNISSEUR, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FournisseurDto>> findAll();

    @ApiOperation(value = "Rechercher un fournisseur par ID", notes = "Cette methode permet de chercher un fournisseur par son ID", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "fournisseur a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun fournisseur n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +FOURNISSEUR +FOURNISSEUR_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FournisseurDto> findById(@PathVariable(FOURNISSEUR_PATH_VARIABLE_ID) Long id);

    @ApiOperation(value = "Enregistrer un fournisseur", notes = "Cette methode permet d'enregistrer ou modifier un fournisseur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet fournisseur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet fournisseur n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + FOURNISSEUR, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FournisseurDto> save(@RequestBody FournisseurDto fournisseurDto);

    @ApiOperation(value = "Supprimer un fournisseur", notes = "Cette methode permet de supprimer un fournisseur par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "fournisseur a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +FOURNISSEUR +FOURNISSEUR_PATH_ID)
    ResponseEntity<?> delete(@PathVariable(FOURNISSEUR_PATH_VARIABLE_ID) Long id);
}
