package com.bbva.challenge.service;

import com.bbva.challenge.repo.BaseRepo;
import com.bbva.challenge.repo.NoSqlRepo;
import com.bbva.challenge.utils.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoSqlService extends BaseService {

    @Autowired
    NoSqlRepo noSqlRepo;

    @Override
    public OperationType getOperationType(String query) {
        if (query.trim().toLowerCase().contains("find")) {
            return OperationType.SELECT;
        } else if (query.trim().toLowerCase().contains("insert")) {
            return OperationType.INSERT;
        }
        return OperationType.NOT_SUPPORTED;
    }

    @Override
    public BaseRepo getRepo() {
        return noSqlRepo;
    }
}
