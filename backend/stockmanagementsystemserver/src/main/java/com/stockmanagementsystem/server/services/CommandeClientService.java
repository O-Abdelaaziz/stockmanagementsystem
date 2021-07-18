package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.CommandeClientDto;

import java.util.List;

/**
 * @Created 18/07/2021 - 17:14
 * @Package com.stockmanagementsystem.server.services
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public interface CommandeClientService {
    List<CommandeClientDto> findAll();
    CommandeClientDto findById(Long id);
    CommandeClientDto findByCode(String code);
    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto update(CommandeClientDto commandeClientDto ,Long id);
    void delete(Long id);
}
