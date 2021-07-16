package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.FournisseurDto;
import com.stockmanagementsystem.server.dto.UtilisateurDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.Fournisseur;
import com.stockmanagementsystem.server.models.Utilisateur;
import com.stockmanagementsystem.server.repositories.UtilisateurRepository;
import com.stockmanagementsystem.server.services.UtilisateurService;
import com.stockmanagementsystem.server.validators.FournisseurValidator;
import com.stockmanagementsystem.server.validators.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return utilisateurRepository.findAll()
                .stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto findById(Long id) {
        if(id == null){
            log.error("-_=> UtilisateurServiceImpl(53) => findById: utilisateur id is null {}",id);
            return null;
        }
        Optional<Utilisateur> utilisateurOptional=utilisateurRepository.findById(id);
        UtilisateurDto utilisateurDto=UtilisateurDto.fromEntity(utilisateurOptional.get());
        return Optional.of(utilisateurDto).orElseThrow(()->new EntityNotFoundException("UtilisateurServiceImpl(58) => findById: no utilisateur found with id: "+id, ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty()){
            log.error("-_=> UtilisateurServiceImpl(65) => save: utilisateur not valid {}",utilisateurDto);
            throw new InvalidEntityException("utilisateur not valid", ErrorCodes.UTILISATEUR_NOT_FOUND);
        }
        Utilisateur newUtilisateur=utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto));
        UtilisateurDto newUtilisateurDto=UtilisateurDto.fromEntity(newUtilisateur);
        return newUtilisateurDto;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("-_=> UtilisateurServiceImpl(76) => delete: utilisateur id is null {}",id);
            return;
        }
        UtilisateurDto utilisateurDto=findById(id);
        Utilisateur utilisateur=UtilisateurDto.toEntity(utilisateurDto);
        utilisateurRepository.delete(utilisateur);
    }
}
