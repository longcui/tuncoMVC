package com.tunco.dao;

import com.tunco.model.Company;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dragon on 17-Mar-15.
 */
@Repository
public class CompanyDaoImpl extends AbstractDao implements CompanyDao {
    @Override
    public void saveCompany(Company company) {
        persist(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        Criteria criteria = getSession().createCriteria(Company.class);
        return criteria.list();
    }

    @Override
    public void deleteCompanyByName(String name) {
        SQLQuery sqlQuery = getSession().createSQLQuery("DELETE FROM company WHERE name = :name");
        sqlQuery.setString("name", name);
        sqlQuery.executeUpdate();
    }

    @Override
    public void deleteCompanyById(int id) {
        SQLQuery sqlQuery = getSession().createSQLQuery("DELETE FROM company WHERE id = :id");
        sqlQuery.setInteger("id", id);
        sqlQuery.executeUpdate();
    }
}
