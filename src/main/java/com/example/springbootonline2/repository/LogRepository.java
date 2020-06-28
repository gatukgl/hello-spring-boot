package com.example.springbootonline2.repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LogRepository {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog() {
        // TODO: save into table log
    }
}
