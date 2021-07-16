package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.UtilisateurDto;
import com.stockmanagementsystem.server.repositories.UtilisateurRepository;
import com.stockmanagementsystem.server.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Created 16/07/2021 - 11:51
 * @Package com.stockmanagementsystem.server.services.impl
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Slf4j
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return null;
    }

    @Override
    public UtilisateurDto findById(Long id) {
        return null;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
