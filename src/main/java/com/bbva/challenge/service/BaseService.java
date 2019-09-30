package com.bbva.challenge.service;

import com.bbva.challenge.repo.BaseRepo;
import com.bbva.challenge.utils.OperationType;

public abstract class BaseService {

    public abstract OperationType getOperationType(String query);

    public abstract BaseRepo getRepo();

    public Object execute(String query) {

        Object response = null;

        OperationType operationType = getOperationType(query);

        if (operationType == null || OperationType.NOT_SUPPORTED.equals(operationType)) {
            return null;
        }

        switch (operationType) {
            case INSERT:
                response = getRepo().executeInsert(query);
                break;
            case SELECT:
                response = getRepo().executeSelect(query);
                break;
            default:
                break;
        }

        return response;
    }

}
