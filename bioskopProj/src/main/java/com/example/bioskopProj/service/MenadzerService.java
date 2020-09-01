package com.example.bioskopProj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioskopProj.entity.Korisnik;
import com.example.bioskopProj.entity.Menadzer;
import com.example.bioskopProj.repository.MenadzerRepository;

@Service
public class MenadzerService {
	@Autowired
	private MenadzerRepository menadzerRepository;
	
	public Menadzer find(String userName,String password) {
		Menadzer m=this.menadzerRepository.findByUserNameAndPassword(userName, password);
		return m;
	}
	
	public Menadzer save(Menadzer men) {
		return this.menadzerRepository.save(men);
	}
	
	public Menadzer registracija(Korisnik k) {
		Menadzer men=new Menadzer();
		
		men.setUserName(k.getUserName());
		men.setPassword(k.getPassword());
		men.setName(k.getName());
		men.setSurname(k.getSurname());
		men.setContactTel(k.getContactTel());
		men.setDate(k.getDate());
		men.setEmail(k.getEmail());

		men.setRole("gledalac");
		men.setActive(true);
		
		return this.menadzerRepository.save(men);
		
	}
}
