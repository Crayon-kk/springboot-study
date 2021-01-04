package com.crayon.kk.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class TransactionalServiceImpl {

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(){



    }
}
