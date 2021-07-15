package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Created 15/07/2021 - 08:30
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Long> {
}
