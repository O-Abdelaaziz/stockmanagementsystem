package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.CommandeClientDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.Article;
import com.stockmanagementsystem.server.models.Client;
import com.stockmanagementsystem.server.models.CommandeClient;
import com.stockmanagementsystem.server.repositories.ArticleRepository;
import com.stockmanagementsystem.server.repositories.ClientRepository;
import com.stockmanagementsystem.server.repositories.CommandeClientRepository;
import com.stockmanagementsystem.server.services.CommandeClientService;
import com.stockmanagementsystem.server.validators.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Created 18/07/2021 - 17:23
 * @Package com.stockmanagementsystem.server.services.impl
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Slf4j
@Transactional
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return null;
    }

    @Override
    public CommandeClientDto findById(Long id) {
        return null;
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return null;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        List<String> errors= CommandeClientValidator.validate(commandeClientDto);
        if(!errors.isEmpty()){
            log.error("-_=> ClientServiceImpl(54) => save: client not valid {}",commandeClientDto);
            throw new InvalidEntityException("client not valid", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
        }

        Optional<Client> optionalClient=clientRepository.findById(commandeClientDto.getClientDto().getId());
        if(!optionalClient.isPresent()){
            log.warn("client with given id {} was not found in the database",commandeClientDto.getClientDto().getId());
            throw new EntityNotFoundException("client not found with id "+commandeClientDto.getClientDto().getId(),ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors=new ArrayList<>();

        if(commandeClientDto.getLigneCommandeClientDtoList() != null){
            commandeClientDto.getLigneCommandeClientDtoList().forEach(
                    ligneCommandeClientDto -> {
                        if(ligneCommandeClientDto.getArticleDto() != null){
                            Optional<Article> article=articleRepository.findById(ligneCommandeClientDto.getArticleDto().getId());
                            if(!article.isPresent()){
                                articleErrors.add("Articlenot found with id "+ligneCommandeClientDto.getArticleDto().getId());
                            }
                        }
                    }
            );
        }

        if(!articleErrors.isEmpty()){
            log.warn("Article not found");
            throw new InvalidEntityException("Article not found",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        CommandeClient newCommandeClient=commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));
        CommandeClientDto newCommandeClientDto=CommandeClientDto.fromEntity(newCommandeClient);
        return newCommandeClientDto ;
    }

    @Override
    public CommandeClientDto update(CommandeClientDto commandeClientDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
