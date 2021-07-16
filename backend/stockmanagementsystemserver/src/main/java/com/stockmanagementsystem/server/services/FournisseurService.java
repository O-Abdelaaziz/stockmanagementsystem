package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.FournisseurDto;

import java.util.List;

/**
 * @Created 16/07/2021 - 11:36
 * @Package com.stockmanagementsystem.server.services
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public interface FournisseurService {
    List<FournisseurDto> findAll();
    FournisseurDto findById(Long id);
    FournisseurDto save(FournisseurDto fournisseurDto);
    void delete(Long id);
}
