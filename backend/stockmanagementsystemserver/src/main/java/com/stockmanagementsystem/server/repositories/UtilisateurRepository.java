package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Created 15/07/2021 - 08:33
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
