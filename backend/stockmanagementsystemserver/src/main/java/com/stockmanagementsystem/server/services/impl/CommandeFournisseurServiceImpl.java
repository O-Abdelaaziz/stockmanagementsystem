package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.CommandeClientDto;
import com.stockmanagementsystem.server.dto.CommandeFournisseurDto;
import com.stockmanagementsystem.server.dto.LigneCommandeClientDto;
import com.stockmanagementsystem.server.dto.LigneCommandeFournisseurDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.*;
import com.stockmanagementsystem.server.repositories.*;
import com.stockmanagementsystem.server.services.CommandeFournisseurService;
import com.stockmanagementsystem.server.validators.CommandeClientValidator;
import com.stockmanagementsystem.server.validators.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Created 19/07/2021 - 10:59
 * @Package com.stockmanagementsystem.server.services.impl
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Slf4j
@Transactional
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository, FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll()
                .stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeFournisseurDto findById(Long id) {
        if(id == null){
            log.error("-_=> CommandeFournisseurServiceImpl(62) => findById: commandeFournisseur id is null {}",id);
            return null;
        }
        Optional<CommandeFournisseur> optionalCommandeFournisseur=commandeFournisseurRepository.findById(id);
        CommandeFournisseurDto commandeFournisseurDto=CommandeFournisseurDto.fromEntity(optionalCommandeFournisseur.get());
        return Optional.of(commandeFournisseurDto).orElseThrow(()->new EntityNotFoundException("CommandeFournisseurServiceImpl(67) => findById: no commandeFournisseur found with id: "+id, ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("-_=> CommandeFournisseurServiceImpl(61 => findByCode: CommandeFournisseur code is null {}",code);
            return null;
        }
        Optional<CommandeFournisseur> optionalCommandeFournisseur=commandeFournisseurRepository.findByCode(code);
        CommandeFournisseurDto commandeFournisseurDto=CommandeFournisseurDto.fromEntity(optionalCommandeFournisseur.get());
        return Optional.of(commandeFournisseurDto).orElseThrow(() -> new EntityNotFoundException("CommandeFournisseurServiceImpl(78) => findByCode: no commandeFournisseur code found with code: "+code,ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errors= CommandeFournisseurValidator.validate(commandeFournisseurDto);
        if(!errors.isEmpty()){
            log.error("-_=> CommandeFournisseurServiceImpl(54) => save: client not valid {}",commandeFournisseurDto);
            throw new InvalidEntityException("client not valid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
        }

        Optional<Fournisseur> optionalFournisseur=fournisseurRepository.findById(commandeFournisseurDto.getFournisseurDto().getId());
        if(!optionalFournisseur.isPresent()){
            log.warn("fournisseur with given id {} was not found in the database",commandeFournisseurDto.getFournisseurDto().getId());
            throw new EntityNotFoundException("fournisseur not found with id "+commandeFournisseurDto.getFournisseurDto().getId(),ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors=new ArrayList<>();

        if(commandeFournisseurDto.getLigneCommandeFournisseurDtoList() != null){
            commandeFournisseurDto.getLigneCommandeFournisseurDtoList().forEach(
                    ligneCommandeFournisseurDto -> {
                        if(ligneCommandeFournisseurDto.getArticleDto() != null){
                            Optional<Article> article=articleRepository.findById(ligneCommandeFournisseurDto.getArticleDto().getId());
                            if(!article.isPresent()){
                                articleErrors.add("Article not found with id "+ligneCommandeFournisseurDto.getArticleDto().getId());
                            }
                        }
                    }
            );
        }

        if(!articleErrors.isEmpty()){
            log.warn("Article not found");
            throw new InvalidEntityException("Article not found",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        CommandeFournisseur newCommandeFournisseur=commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));
        if(commandeFournisseurDto.getLigneCommandeFournisseurDtoList() != null){
            commandeFournisseurDto.getLigneCommandeFournisseurDtoList().forEach(
                    ligneCommandeFournisseurDto -> {
                        LigneCommandeFournisseur newLigneCommandeFournisseur= LigneCommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto);
                        newLigneCommandeFournisseur.setCommandeFournisseur(newCommandeFournisseur);
                        ligneCommandeFournisseurRepository.save(newLigneCommandeFournisseur);
                    }
            );
        }

        CommandeFournisseurDto newCommandeFournisseurDto=CommandeFournisseurDto.fromEntity(newCommandeFournisseur);
        return newCommandeFournisseurDto ;
    }

    @Override
    public CommandeFournisseurDto update(CommandeFournisseurDto commandeFournisseurDto, Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("-_=> CommandeFournisseurServiceImpl(138) => delete: CommandeFournisseur id is null {}",id);
            return;
        }
        CommandeFournisseurDto commandeFournisseurDto=findById(id);
        CommandeFournisseur commandeFournisseur =CommandeFournisseurDto.toEntity(commandeFournisseurDto);
        commandeFournisseurRepository.delete(commandeFournisseur);
    }
}
