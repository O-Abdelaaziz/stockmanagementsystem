package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;
import static com.stockmanagementsystem.server.controllers.constants.APIName.UTILISATEUR_PATH_VARIABLE_ID;

/**
 * @Created 25/07/2021 - 14:59
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("utilisateurs")
public interface UtilisateurApi {

    @GetMapping(value =APP_ROOT +  UTILISATEUR, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UtilisateurDto>> findAll();

    @ApiOperation(value = "Rechercher un utilisateur par ID", notes = "Cette methode permet de chercher un utilisateur par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun utilisateur n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +UTILISATEUR +UTILISATEUR_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurDto> findById(@PathVariable(UTILISATEUR_PATH_VARIABLE_ID) Long id);

    @ApiOperation(value = "Enregistrer un utilisateur", notes = "Cette methode permet d'enregistrer ou modifier un utilisateur", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet utilisateur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet utilisateur n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + UTILISATEUR, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurDto> save(@RequestBody UtilisateurDto utilisateurDto);

    @ApiOperation(value = "Supprimer un utilisateur", notes = "Cette methode permet de supprimer un utilisateur par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +UTILISATEUR +UTILISATEUR_PATH_ID)
    ResponseEntity<?> delete(@PathVariable(UTILISATEUR_PATH_VARIABLE_ID) Long id);
}
