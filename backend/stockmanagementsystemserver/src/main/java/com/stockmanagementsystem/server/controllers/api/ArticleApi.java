package com.stockmanagementsystem.server.controllers.api;

import com.stockmanagementsystem.server.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stockmanagementsystem.server.controllers.constants.APIName.*;

/**
 * @Created 22/07/2021 - 13:35
 * @Package com.stockmanagementsystem.server.controllers.api
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Api("articles")
public interface ArticleApi {

    @GetMapping(value =APP_ROOT +  ARTICLES, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value = APP_ROOT +ARTICLES +ARTICLE_PATH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable(ARTICLE_PATH_VARIABLE_ID) Long id);

    @ApiOperation(value = "Rechercher un article par CODE", notes = "Cette methode permet de chercher un article par son CODE", response =
            ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    @GetMapping(value = APP_ROOT +ARTICLES +ARTICLE_PATH_CODE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable(ARTICLE_PATH_VARIABLE_CODE) String codeArticle);

    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide")
    })
    @PostMapping(value = APP_ROOT + ARTICLES, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete supprime")
    })
    @DeleteMapping(value = APP_ROOT +ARTICLES +ARTICLE_PATH_ID)
    void delete(@PathVariable(ARTICLE_PATH_VARIABLE_ID) Long id);
}
