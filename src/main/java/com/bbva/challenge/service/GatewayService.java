package com.bbva.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayService {

    @Autowired
    SqlService sqlService;

    @Autowired
    NoSqlService noSqlService;

    public BaseService getService(String query) {

        if (isSqlQuery(query)) {
            return sqlService;
        } else if (isNoSqlQuery(query)) {
            return noSqlService;
        }

        return null;

    }

    private boolean isSqlQuery(String query) {
        String q = query.trim().toUpperCase();
        return q.startsWith("SELECT") || q.startsWith("INSERT");
    }

    private boolean isNoSqlQuery(String query) {
        String q = query.trim().toLowerCase();
        return q.contains("find") || q.contains("insert");
    }



}
