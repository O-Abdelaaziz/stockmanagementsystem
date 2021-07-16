package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.EntrepriseDto;
import com.stockmanagementsystem.server.repositories.EntrepriseRepository;
import com.stockmanagementsystem.server.services.EntrepriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return null;
    }

    @Override
    public EntrepriseDto findById(Long id) {
        return null;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
