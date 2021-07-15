package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Created 15/07/2021 - 08:23
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Long> {
}
