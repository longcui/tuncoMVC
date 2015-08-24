package com.tunco.service;

import com.tunco.dao.CompanyDao;
import com.tunco.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dragon on 17-Mar-15.
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDao companyDao;
    @Override
    public void saveCompany(Company company) {
        companyDao.saveCompany(company);
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public void deleteCompanyByName(String name) {
        companyDao.deleteCompanyByName(name);
    }

    @Override
    public void deleteCompanyById(int id) {
        companyDao.deleteCompanyById(id);
    }
}
