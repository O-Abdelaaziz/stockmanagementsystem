package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.CommandeFournisseurDto;

import java.util.List;

/**
 * @Created 19/07/2021 - 10:59
 * @Package com.stockmanagementsystem.server.services
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public interface CommandeFournisseurService {
    List<CommandeFournisseurDto> findAll();
    CommandeFournisseurDto findById(Long id);
    CommandeFournisseurDto findByCode(String code);
    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseurDto update(CommandeFournisseurDto commandeFournisseurDto ,Long id);
    void delete(Long id);
}
