package com.example.bioskopProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bioskopProj.entity.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{
	
	Administrator findByUserNameAndPassword(String userName,String password);
}
