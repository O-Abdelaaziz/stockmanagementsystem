package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.ClientDto;
import com.stockmanagementsystem.server.repositories.ClientRepository;
import com.stockmanagementsystem.server.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return null;
    }

    @Override
    public ClientDto findById(Integer id) {
        return null;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
