package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Created 15/07/2021 - 08:20
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByCode(String code);
}
