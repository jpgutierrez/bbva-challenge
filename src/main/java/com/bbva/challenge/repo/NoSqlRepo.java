package com.bbva.challenge.repo;

import com.bbva.challenge.utils.OperationType;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class NoSqlRepo implements BaseRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Object executeSelect(String query) {
        System.out.println("NO SQL SELECT");

        String collectionName = getCollectionName(query);

        String params = getParams(query, "find");

        if ("".equals(params)) {
            params = "{}";
        }

        return mongoTemplate.find(new BasicQuery(params), HashMap.class, collectionName);
    }

    @Override
    public boolean executeInsert(String query) {
        System.out.println("NO SQL INSERT");

        String collectionName = getCollectionName(query);

        String params = getParams(query, "insert");

        Document doc = Document.parse(params);

        Document inserted = mongoTemplate.insert(doc, collectionName);

        return inserted != null && inserted.get("_id") != null;

    }

    private String getCollectionName(String query) {
        String[] values = query.split("\\.");
        String collectionName = values[1];
        return collectionName;
    }

    private String getParams(String query, String command) {
        int idx = query.toLowerCase().indexOf(command + "(");

        String params = query.substring(idx + command.length() + 1, query.length() - 1).trim();

        return params;
    }

}
