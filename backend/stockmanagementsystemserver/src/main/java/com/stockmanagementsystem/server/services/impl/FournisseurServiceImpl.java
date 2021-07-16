package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.EntrepriseDto;
import com.stockmanagementsystem.server.dto.FournisseurDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.models.Entreprise;
import com.stockmanagementsystem.server.models.Fournisseur;
import com.stockmanagementsystem.server.repositories.FournisseurRepository;
import com.stockmanagementsystem.server.services.FournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Created 16/07/2021 - 11:38
 * @Package com.stockmanagementsystem.server.services.impl
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Slf4j
@Transactional
public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll()
                .stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FournisseurDto findById(Long id) {
        if(id == null){
            log.error("-_=> FournisseurServiceImpl(42) => findById: entreprise id is null {}",id);
            return null;
        }
        Optional<Fournisseur> fournisseurOptional=fournisseurRepository.findById(id);
        FournisseurDto fournisseurDto=FournisseurDto.fromEntity(fournisseurOptional.get());
        return Optional.of(fournisseurDto).orElseThrow(()->new EntityNotFoundException("FournisseurServiceImpl(50) => findById: no entreprise found with id: "+id, ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
