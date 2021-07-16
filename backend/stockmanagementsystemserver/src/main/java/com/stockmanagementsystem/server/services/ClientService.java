package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAll();
    ClientDto findById(Long id);
    ClientDto save(ClientDto clientDto);
    void delete(Long id);
}
