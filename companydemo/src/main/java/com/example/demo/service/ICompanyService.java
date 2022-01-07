package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Company;

public interface ICompanyService {
	String save(Company comp) throws Exception;
	
	List<Company> getAllCompanies();
	
	void deleteCompanyById(long id);
	
	void updateCompany(Company comp, long id);
}
