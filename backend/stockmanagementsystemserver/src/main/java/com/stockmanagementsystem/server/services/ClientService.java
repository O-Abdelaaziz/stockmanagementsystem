package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAll();
    ClientDto findById(Integer id);
    ClientDto save(ClientDto dto);
    void delete(Integer id);
}
