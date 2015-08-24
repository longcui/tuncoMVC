package com.tunco.dao;

import com.tunco.model.FacebookUser;
import com.tunco.model.User;
import com.tunco.model.UserRole;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{
 
    public void saveUser(User user) {
        if(user instanceof FacebookUser) {
            FacebookUser fbUser = (FacebookUser) user;
            if(getFbUser(fbUser.getEmail()) == null) {
                persist(fbUser);
            }
        } else {
            if(getUser(user.getEmail()) == null) {
                persist(user);
                persist(new UserRole(user.getName(), "ROLE_USER"));
            }
        }
    }

    private FacebookUser getFbUser(String email) {
        Object o = getSession().createCriteria(FacebookUser.class).add(Restrictions.eq("email", email)).uniqueResult();
        return (FacebookUser) o;
    }

    public User getUser(String email) {
        return (User) getSession().createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
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