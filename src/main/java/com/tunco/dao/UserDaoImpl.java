package com.tunco.dao;

import com.tunco.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{
 
    public void saveUser(User user) {
        persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    public void deleteUserByName(String name) {
        Query query = getSession().createSQLQuery("delete from User where name = :name");
        query.setString("name", name);
        query.executeUpdate();
    }

    public void deleteUserById(int id) {
        Query query = getSession().createSQLQuery("delete from User where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

}