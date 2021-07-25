package com.stockmanagementsystem.server.controllers;

import com.stockmanagementsystem.server.controllers.api.ArticleApi;
import com.stockmanagementsystem.server.dto.ArticleDto;
import com.stockmanagementsystem.server.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 22/07/2021 - 14:01
 * @Package com.stockmanagementsystem.server.controllers
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public ArticleDto findById(Long id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCode(codeArticle);
    }
    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public void delete(Long id) {
        articleService.delete(id);
    }
}
