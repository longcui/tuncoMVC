package com.tunco.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dragon on 17-Mar-15.
 */
@Repository
public class GenericDao extends AbstractDao {
    public List<Object> getAll(Class aClass) {
        Criteria criteria = getSession().createCriteria(aClass);
        return  criteria.list();
    }
}
