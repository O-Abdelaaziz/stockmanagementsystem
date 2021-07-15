package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.ArticleDto;

import java.util.List;

/**
 * @Created 15/07/2021 - 09:50
 * @Package com.stockmanagementsystem.server.services
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public interface ArticleService {

    List<ArticleDto> findAll();
    ArticleDto findById(Long id);
    ArticleDto findByCode(String code);
    ArticleDto save(ArticleDto articleDto);
    ArticleDto update(ArticleDto articleDto ,Long id);
    void  delete(Long id);

}
