package com.stockmanagementsystem.server.interceptors;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
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
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            // select utilisateu0_.
            final String entityName = sql.substring(7, sql.indexOf("."));
            final String idEntreprise = MDC.get("entreprise_id");
            if (StringUtils.hasLength(entityName)
                    && !entityName.toLowerCase().contains("entreprise")
                    && !entityName.toLowerCase().contains("roles")
                    && StringUtils.hasLength(idEntreprise)) {

                if (sql.contains("where")) {
                    sql = sql + " and " + entityName + ".entreprise_id = " + idEntreprise;
                } else {
                    sql = sql + " where " + entityName + ".entreprise_id = " + idEntreprise;
                }
            }
        }
        return super.onPrepareStatement(sql);
    }
}
