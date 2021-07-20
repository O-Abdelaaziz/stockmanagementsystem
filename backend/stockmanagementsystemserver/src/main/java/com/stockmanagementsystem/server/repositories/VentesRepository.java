package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Created 15/07/2021 - 08:34
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface VentesRepository extends JpaRepository<Ventes,Long> {
    Optional<Ventes> findByCode(String code);
}
