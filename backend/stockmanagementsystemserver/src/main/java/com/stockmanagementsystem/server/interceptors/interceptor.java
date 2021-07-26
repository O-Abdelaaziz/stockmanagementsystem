package com.stockmanagementsystem.server.interceptors;

import org.hibernate.EmptyInterceptor;
import org.springframework.util.StringUtils;

/**
 * @Created 25/07/2021 - 15:40
 * @Package com.stockmanagementsystem.server.interceptors
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class interceptor extends EmptyInterceptor {


    @Override
    public String onPrepareStatement(String sql) {
        if(StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")){
            if(sql.contains("where")){
                sql= sql + " and entreprise_id = 1";
            }else{
                sql= sql + " where entreprise_id = 1";
            }

        }
        return super.onPrepareStatement(sql);
    }
}
