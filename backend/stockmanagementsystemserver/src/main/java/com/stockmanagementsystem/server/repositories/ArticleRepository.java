package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Created 14/07/2021 - 13:55
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
