package com.bbva.challenge.repo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class SqlRepo implements BaseRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Object executeSelect(String query) {
        System.out.println("SQL SELECT");
        Object response = entityManager.createNativeQuery(query).getResultList();
        return response;
    }

    @Transactional
    @Override
    public boolean executeInsert(String query) {
        System.out.println("SQL INSERT");

        try {
            entityManager.joinTransaction();
            entityManager.createNativeQuery(query).executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
