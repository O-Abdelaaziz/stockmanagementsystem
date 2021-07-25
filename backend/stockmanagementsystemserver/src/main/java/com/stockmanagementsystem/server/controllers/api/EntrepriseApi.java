package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;
import static com.stockmanagementsystem.server.controllers.constants.APIName.ENTREPRISE_PATH_VARIABLE_ID;

/**
 * @Created 25/07/2021 - 14:31
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("fournisseurs")
public interface EntrepriseApi {
    @GetMapping(value =APP_ROOT +  ENTREPRISE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EntrepriseDto>> findAll();

    @ApiOperation(value = "Rechercher un entreprise par ID", notes = "Cette methode permet de chercher un entreprise par son ID", response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "entreprise a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun entreprise n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +ENTREPRISE +ENTREPRISE_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntrepriseDto> findById(@PathVariable(ENTREPRISE_PATH_VARIABLE_ID) Long id);

    @ApiOperation(value = "Enregistrer un entreprise", notes = "Cette methode permet d'enregistrer ou modifier un entreprise", response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet entreprise cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet entreprise n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + ENTREPRISE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntrepriseDto> save(@RequestBody EntrepriseDto entrepriseDto);

    @ApiOperation(value = "Supprimer un entreprise", notes = "Cette methode permet de supprimer un entreprise par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "entreprise a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +ENTREPRISE +ENTREPRISE_PATH_ID)
    ResponseEntity<?> delete(@PathVariable(ENTREPRISE_PATH_VARIABLE_ID) Long id);
}
