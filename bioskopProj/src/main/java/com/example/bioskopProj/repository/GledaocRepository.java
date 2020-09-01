package com.example.bioskopProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bioskopProj.entity.Gledaoc;


public interface GledaocRepository extends JpaRepository<Gledaoc, Long>{
	
	Gledaoc findByUserNameAndPassword(String userName,String password);
}
