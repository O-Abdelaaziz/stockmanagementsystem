package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Created 15/07/2021 - 08:32
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {
}
