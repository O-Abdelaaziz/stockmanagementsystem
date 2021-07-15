package com.stockmanagementsystem.server.repositories;

import com.stockmanagementsystem.server.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created 14/07/2021 - 13:55
 * @Package com.stockmanagementsystem.server.repositories
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    //JPQL Query
    @Query("select a from Article a where a.code=:code and a.designation=:designation")
    List<Article> findByCustomQuery(@Param("code") String code, @Param("designation") String designation);

    //Native Query
    @Query("select * from article where code=:code")
    List<Article> findByNativeQuery(@Param("code") String code);

    //JPA Query Builder
    List<Article> findByCodeIgnoreCaseAndDesignationIgnoreCase(String code,String designation);


}
