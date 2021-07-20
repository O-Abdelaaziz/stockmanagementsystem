package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.CommandeClientDto;
import com.stockmanagementsystem.server.dto.CommandeFournisseurDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.models.CommandeClient;
import com.stockmanagementsystem.server.models.CommandeFournisseur;
import com.stockmanagementsystem.server.repositories.ArticleRepository;
import com.stockmanagementsystem.server.repositories.ClientRepository;
import com.stockmanagementsystem.server.repositories.CommandeFournisseurRepository;
import com.stockmanagementsystem.server.repositories.LigneCommandeFournisseurRepository;
import com.stockmanagementsystem.server.services.CommandeFournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.clientRepository = clientRepository;
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
        return null;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        return null;
    }

    @Override
    public CommandeFournisseurDto update(CommandeFournisseurDto commandeFournisseurDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
