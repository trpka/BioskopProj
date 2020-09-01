package com.example.bioskopProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioskopProj.entity.Administrator;
import com.example.bioskopProj.repository.AdministratorRepository;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorRepository administratorRepository;
	
	public Administrator find(String userName,String password) {
		
		Administrator a=this.administratorRepository.findByUserNameAndPassword(userName, password);
		
		return a;
	}
}
