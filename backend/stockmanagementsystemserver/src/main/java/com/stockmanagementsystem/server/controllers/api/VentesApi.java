package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.VentesDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;
import static com.stockmanagementsystem.server.controllers.constants.APIName.VENTES_PATH_VARIABLE_CODE;

/**
 * @Created 25/07/2021 - 14:47
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("ventes")
public interface VentesApi {

    @GetMapping(value =APP_ROOT +  VENTES, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<VentesDto>> findAll();

    @ApiOperation(value = "Rechercher un ventes par ID", notes = "Cette methode permet de chercher un ventes par son ID", response = VentesDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ventes a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun ventes n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +VENTES +VENTES_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VentesDto> findById(@PathVariable(VENTES_PATH_VARIABLE_CODE) Long id);


    @ApiOperation(value = "Rechercher un ventes par CODE", notes = "Cette methode permet de chercher un ventes par son CODE", response = VentesDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ventes a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun ventes n'existe dans la BDD avec le CODE fourni")
    })
    @GetMapping(value = APP_ROOT +VENTES +VENTES_PATH_CODE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VentesDto> findByCode(@PathVariable(VENTES_PATH_VARIABLE_CODE) String code);

    @ApiOperation(value = "Enregistrer un ventes", notes = "Cette methode permet d'enregistrer ou modifier un ventes", response = VentesDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet ventes cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet ventes n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + VENTES, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VentesDto> save(@RequestBody VentesDto ventesDto);

    @ApiOperation(value = "Supprimer un ventes", notes = "Cette methode permet de supprimer un ventes par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ventes a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +VENTES +VENTES_PATH_ID)
    ResponseEntity<?> delete(@PathVariable(VENTES_PATH_VARIABLE_CODE) Long id);
}
