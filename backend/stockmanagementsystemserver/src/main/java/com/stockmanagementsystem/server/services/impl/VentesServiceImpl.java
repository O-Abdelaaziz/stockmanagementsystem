package com.stockmanagementsystem.server.services.impl;

import com.stockmanagementsystem.server.dto.CommandeClientDto;
import com.stockmanagementsystem.server.dto.LigneVenteDto;
import com.stockmanagementsystem.server.dto.VentesDto;
import com.stockmanagementsystem.server.exceptions.EntityNotFoundException;
import com.stockmanagementsystem.server.exceptions.ErrorCodes;
import com.stockmanagementsystem.server.exceptions.InvalidEntityException;
import com.stockmanagementsystem.server.models.Article;
import com.stockmanagementsystem.server.models.CommandeClient;
import com.stockmanagementsystem.server.models.LigneVente;
import com.stockmanagementsystem.server.models.Ventes;
import com.stockmanagementsystem.server.repositories.ArticleRepository;
import com.stockmanagementsystem.server.repositories.LigneVenteRepository;
import com.stockmanagementsystem.server.repositories.VentesRepository;
import com.stockmanagementsystem.server.services.VentesService;
import com.stockmanagementsystem.server.validators.CommandeClientValidator;
import com.stockmanagementsystem.server.validators.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if(id == null){
            log.error("-_=> VentesServiceImpl(62) => findById: ventes id is null {}",id);
            return null;
        }
        Optional<Ventes> optionalVentes=ventesRepository.findById(id);
        VentesDto ventesDto=VentesDto.fromEntity(optionalVentes.get());
        return Optional.of(ventesDto).orElseThrow(()->new EntityNotFoundException("VentesServiceImpl(67) => findById: no ventes found with id: "+id, ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findByCode(String code) {
        if(code == null){
            log.error("-_=> VentesServiceImpl(62) => findByCode: ventes id is null {}",code);
            return null;
        }
        Optional<Ventes> optionalVentes=ventesRepository.findByCode(code);
        VentesDto ventesDto=VentesDto.fromEntity(optionalVentes.get());
        return Optional.of(ventesDto).orElseThrow(()->new EntityNotFoundException("VentesServiceImpl(67) => findByCode: no ventes found with code: "+code, ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto save(VentesDto ventesDto) {
        List<String> errors= VentesValidator.validate(ventesDto);
        if(!errors.isEmpty()){
            log.error("-_=> VentesServiceImpl(54) => save: client not valid {}",ventesDto);
            throw new InvalidEntityException("client not valid", ErrorCodes.VENTE_NOT_FOUND);
        }

        List<String> ventesErrors=new ArrayList<>();

        ventesDto.getLigneVenteDtoList().forEach(
            ligneVenteDto -> {
                Optional<Article> article=articleRepository.findById(ligneVenteDto.getArticleDto().getId());
                if(!article.isPresent()){
                    ventesErrors.add("Articlenot found with id "+ligneVenteDto.getArticleDto().getId());
                }
            }
        );

        if(!ventesErrors.isEmpty()){
            log.warn("Article not found");
            throw new InvalidEntityException("Article not found",ErrorCodes.VENTE_NOT_FOUND,ventesErrors);
        }

        Ventes ventes=ventesRepository.save(VentesDto.toEntity(ventesDto));

        ventesDto.getLigneVenteDtoList().forEach(
                ligneVenteDto -> {
                    LigneVente newLigneVente= LigneVenteDto.toEntity(ligneVenteDto);
                    ligneVenteDto.setVentesDto(ventesDto);
                    ligneVenteRepository.save(newLigneVente);
                }
        );

        VentesDto newVentesDto=VentesDto.fromEntity(ventes);

        return newVentesDto;
    }

    @Override
    public VentesDto update(VentesDto ventesDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("-_=> VentesServiceImpl(138) => delete: ventes id is null {}",id);
            return;
        }
        VentesDto ventesDto=findById(id);
        Ventes ventes=VentesDto.toEntity(ventesDto);
        ventesRepository.delete(ventes);
    }
}
