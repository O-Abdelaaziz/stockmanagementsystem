package com.stockmanagementsystem.server.services;

import com.stockmanagementsystem.server.dto.VentesDto;

import java.util.List;

/**
 * @Created 20/07/2021 - 10:04
 * @Package com.stockmanagementsystem.server.services
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public interface VentesService {
    List<VentesDto> findAll();
    VentesDto findById(Long id);
    VentesDto findByCode(String code);
    VentesDto save(VentesDto ventesDto);
    VentesDto update(VentesDto ventesDto,Long id);
    void delete(Long id);
}
