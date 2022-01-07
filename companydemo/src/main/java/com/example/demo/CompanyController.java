package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entity.Company;
import com.example.demo.service.ICompanyService;

public class CompanyController {
	@Autowired
	ICompanyService compService;
	
	@PostMapping("/company")
	@ResponseStatus(code = HttpStatus.CREATED)
	Long createCompany(@RequestBody Company comp) throws Exception {
		compService.save(comp);
		return comp.getId();
	}
	
	@PutMapping("/company/{id}")
	void updateCompany(@RequestBody Company comp, @PathVariable Long id) {
		compService.updateCompany(comp, id);
	}
	
	@GetMapping("/company")
	List<Company> getAllUsers() {
		return compService.getAllCompanies();
	}
}
