package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Created 12/07/2021 - 09:03
 * @Package com.stockmanagementsystem.server.models
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories",schema = "public")
public class Category extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Article> articleList;
}
