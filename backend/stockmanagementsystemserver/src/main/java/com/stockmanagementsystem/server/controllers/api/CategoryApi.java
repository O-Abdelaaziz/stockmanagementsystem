package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;
import static com.stockmanagementsystem.server.controllers.constants.APIName.ARTICLE_PATH_VARIABLE_ID;

/**
 * @Created 25/07/2021 - 13:34
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("categories")
public interface CategoryApi {
    @GetMapping(value =APP_ROOT +  CATEGORY, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @ApiOperation(value = "Rechercher un category par ID", notes = "Cette methode permet de chercher un category par son ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun category n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +CATEGORY +CATEGORY_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable(CATEGORY_PATH_VARIABLE_ID) Long id);

    @ApiOperation(value = "Rechercher un category par CODE", notes = "Cette methode permet de chercher un category par son CODE", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun category n'existe dans la BDD avec le CODE fourni")
    })
    @GetMapping(value = APP_ROOT +CATEGORY +CATEGORY_PATH_CODE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findCategoryByCode(@PathVariable(CATEGORY_PATH_VARIABLE_CODE) String code);

    @ApiOperation(value = "Enregistrer un category", notes = "Cette methode permet d'enregistrer ou modifier un category", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet category cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet category n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + CATEGORY, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @ApiOperation(value = "Supprimer un category", notes = "Cette methode permet de supprimer un category par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "category a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +CATEGORY +CATEGORY_PATH_ID)
    void delete(@PathVariable(CATEGORY_PATH_VARIABLE_ID) Long id);
}
