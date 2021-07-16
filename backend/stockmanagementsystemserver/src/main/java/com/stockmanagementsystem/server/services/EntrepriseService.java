package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    List<EntrepriseDto> findAll();
    EntrepriseDto findById(Long id);
    EntrepriseDto save(EntrepriseDto entrepriseDto);
    void delete(Long id);
}
