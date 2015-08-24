package com.tunco.service;

import com.tunco.model.Company;

import java.util.List;

/**
 * Created by dragon on 17-Mar-15.
 */
public interface CompanyService {
    void saveCompany(Company company);

    List<Company> getAllCompanies();

    void deleteCompanyByName(String name);

    void deleteCompanyById(int id);
}
