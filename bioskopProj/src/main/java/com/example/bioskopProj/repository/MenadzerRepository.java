package com.example.bioskopProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bioskopProj.entity.Menadzer;

public interface MenadzerRepository extends JpaRepository<Menadzer, Long>{
	Menadzer findByUserNameAndPassword(String userName,String password);
}
