package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.EntrepriseDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.Entreprise;
import com.stockmanagementsystem.server.repositories.EntrepriseRepository;
import com.stockmanagementsystem.server.services.EntrepriseService;
import com.stockmanagementsystem.server.validators.EntrepriseValidator;
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
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll()
                .stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto findById(Long id) {
        if(id == null){
            log.error("-_=> EntrepriseServiceImpl(42) => findById: entreprise id is null {}",id);
            return null;
        }
        Optional<Entreprise> entrepriseOptional=entrepriseRepository.findById(id);
        EntrepriseDto entrepriseDto=EntrepriseDto.fromEntity(entrepriseOptional.get());
        return Optional.of(entrepriseDto).orElseThrow(()->new EntityNotFoundException("EntrepriseServiceImpl(50) => findById: no entreprise found with id: "+id, ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("-_=> EntrepriseServiceImpl(54) => save: entreprise not valid {}",entrepriseDto);
            throw new InvalidEntityException("Article not valid", ErrorCodes.ENTREPRISE_NOT_FOUND);
        }
        Entreprise newEntreprise=entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto));
        EntrepriseDto newEntrepriseDto=EntrepriseDto.fromEntity(newEntreprise);
        return newEntrepriseDto;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("-_=> EntrepriseServiceImpl(65) => delete: entreprise id is null {}",id);
            return;
        }
        EntrepriseDto entrepriseDto=findById(id);
        Entreprise entreprise=EntrepriseDto.toEntity(entrepriseDto);
        entrepriseRepository.delete(entreprise);
    }
}
