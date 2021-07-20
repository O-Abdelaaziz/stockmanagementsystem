package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.VentesDto;
import com.stockmanagementsystem.server.repositories.ArticleRepository;
import com.stockmanagementsystem.server.repositories.LigneVenteRepository;
import com.stockmanagementsystem.server.repositories.VentesRepository;
import com.stockmanagementsystem.server.services.VentesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Created 20/07/2021 - 10:04
 * @Package com.stockmanagementsystem.server.services.impl
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Slf4j
@Transactional
public class VentesServiceImpl implements VentesService {
    private VentesRepository ventesRepository;
    private LigneVenteRepository ligneVenteRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public VentesServiceImpl(VentesRepository ventesRepository, LigneVenteRepository ligneVenteRepository, ArticleRepository articleRepository) {
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<VentesDto> findAll() {
        return null;
    }

    @Override
    public VentesDto findById(Long id) {
        return null;
    }

    @Override
    public VentesDto findByCode(String code) {
        return null;
    }

    @Override
    public VentesDto save(VentesDto ventesDto) {
        return null;
    }

    @Override
    public VentesDto update(VentesDto ventesDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
