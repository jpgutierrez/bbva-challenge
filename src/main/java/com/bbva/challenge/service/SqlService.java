package com.bbva.challenge.service;

import com.bbva.challenge.repo.BaseRepo;
import com.bbva.challenge.repo.SqlRepo;
import com.bbva.challenge.utils.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqlService extends BaseService {

    @Autowired
    SqlRepo sqlRepo;

    @Override
    public OperationType getOperationType(String query) {
        if (query.trim().toUpperCase().startsWith("SELECT")) {
            return OperationType.SELECT;
        } else if (query.trim().toUpperCase().startsWith("INSERT")) {
            return OperationType.INSERT;
        }
        return OperationType.NOT_SUPPORTED;
    }

    @Override
    public BaseRepo getRepo() {
        return sqlRepo;
    }
}
