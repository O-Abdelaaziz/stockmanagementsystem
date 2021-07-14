package com.stockmanagementsystem.server.models;

import com.stockmanagementsystem.server.models.common.AbstractEntity;
import lombok.*;

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
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories",schema = "public")
public class Category extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "entreprise_id")
    private Long entrepriseId;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Article> articleList;
}
