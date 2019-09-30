package com.bbva.challenge.repo;

public interface BaseRepo {

    Object executeSelect(String query);
    boolean executeInsert(String query);

}
