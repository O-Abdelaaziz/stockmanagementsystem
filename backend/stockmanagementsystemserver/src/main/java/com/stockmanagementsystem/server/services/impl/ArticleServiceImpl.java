package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.ArticleDto;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.Article;
import com.stockmanagementsystem.server.repositories.ArticleRepository;
import com.stockmanagementsystem.server.services.ArticleService;
import com.stockmanagementsystem.server.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Created 15/07/2021 - 10:09
 * @Package com.stockmanagementsystem.server.services.impl
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Slf4j
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public ArticleDto findById(Long id) {
        return null;
    }

    @Override
    public ArticleDto findByCode(String code) {
        return null;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
           log.error("-_=> ArticleServiceImpl(52) => Save: Article not valid {}",articleDto);
           throw new InvalidEntityException("Article not valid", ErrorCodes.ARTICLE_NOT_VALID);
        }
        Article newArticle=articleRepository.save(ArticleDto.toEntity(articleDto));
        ArticleDto newArticleDto=ArticleDto.fromEntity(newArticle);
        return newArticleDto;
    }

    @Override
    public ArticleDto update(ArticleDto articleDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
