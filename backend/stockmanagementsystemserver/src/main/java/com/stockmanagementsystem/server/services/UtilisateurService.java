package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.UtilisateurDto;

import java.util.List;

/**
 * @Created 16/07/2021 - 11:51
 * @Package com.stockmanagementsystem.server.services
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public interface UtilisateurService {
    List<UtilisateurDto> findAll();
    UtilisateurDto findById(Long id);
    UtilisateurDto save(UtilisateurDto utilisateurDto);
    void delete(Long id);
}
