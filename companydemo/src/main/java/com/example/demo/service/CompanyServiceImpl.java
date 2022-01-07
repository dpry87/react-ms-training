package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;

public class CompanyServiceImpl implements ICompanyService {
	@Autowired
	CompanyRepository repository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public String save(Company comp) throws Exception {
		repository.save(comp);
		return comp.getCompanyName();
	}
	
	public List<Company> getAllCompanies() {
		return repository.findAll();
	}
	
	public void deleteCompanyById(long id) {
		
	}
	
	public void updateCompany(Company comp, long id) {
		comp.setId(id);
		repository.save(comp);
	}

}
