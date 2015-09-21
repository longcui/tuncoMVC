package com.tunco.service;

import com.tunco.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dragon on 17-Mar-15.
 */
@Service("genericService")
@Transactional
public class GenericService {
    @Autowired
    GenericDao genericDao;

    public List<Object> getAll(Class aClass) {
        return genericDao.getAll(aClass);
    }

}

