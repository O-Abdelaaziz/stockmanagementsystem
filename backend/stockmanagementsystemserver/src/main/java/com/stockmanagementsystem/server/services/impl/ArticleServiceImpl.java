package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.ArticleDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
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
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto findById(Long id) {
        if(id == null){
            log.error("-_=> ArticleServiceImpl(50) => findById: Article id is null {}",id);
            return null;
        }
        Optional<Article> articleOptional=articleRepository.findById(id);
        ArticleDto articleDto=ArticleDto.fromEntity(articleOptional.get());
        return Optional.of(articleDto).orElseThrow(()->new EntityNotFoundException("ArticleServiceImpl(50) => findById: no article found with id: "+id,ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("-_=> ArticleServiceImpl(61 => findByCode: Article code is null {}",code);
            return null;
        }
        Optional<Article> article=articleRepository.findByCode(code);
        ArticleDto articleDto=ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow(() -> new EntityNotFoundException("ArticleServiceImpl(66) => findByCode: no Article code found with code: "+code,ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
           log.error("-_=> ArticleServiceImpl(73) => save: Article not valid {}",articleDto);
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
        if(id==null){
            log.error("-_=> ArticleServiceImpl(89) => delete: Article id is null {}",id);
            return;
        }
        ArticleDto articleDto=findById(id);
        Article article=ArticleDto.toEntity(articleDto);
        articleRepository.delete(article);
    }
}
