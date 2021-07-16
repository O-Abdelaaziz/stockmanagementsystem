package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.ArticleDto;
import com.stockmanagementsystem.server.dto.ClientDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.Article;
import com.stockmanagementsystem.server.models.Client;
import com.stockmanagementsystem.server.repositories.ClientRepository;
import com.stockmanagementsystem.server.services.ClientService;
import com.stockmanagementsystem.server.validators.ArticleValidator;
import com.stockmanagementsystem.server.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Long id) {
        if(id == null){
            log.error("-_=> ClientServiceImpl(45) => findById: client id is null {}",id);
            return null;
        }
        Optional<Client> optionalClient=clientRepository.findById(id);
        ClientDto clientDto=ClientDto.fromEntity(optionalClient.get());
        return Optional.of(clientDto).orElseThrow(()->new EntityNotFoundException("ClientServiceImpl(47) => findById: no client found with id: "+id, ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("-_=> ClientServiceImpl(57) => save: client not valid {}",clientDto);
            throw new InvalidEntityException("client not valid", ErrorCodes.ARTICLE_NOT_VALID);
        }
        Client newClient=clientRepository.save(ClientDto.toEntity(clientDto));
        ClientDto newClientDto=ClientDto.fromEntity(newClient);
        return newClientDto;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("-_=> ClientServiceImpl(68) => delete: client id is null {}",id);
            return;
        }
        ClientDto clientDto=findById(id);
        Client client=ClientDto.toEntity(clientDto);
        clientRepository.delete(client);
    }
}
