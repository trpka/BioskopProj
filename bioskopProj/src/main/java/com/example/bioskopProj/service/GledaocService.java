package com.example.bioskopProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioskopProj.entity.Gledaoc;
import com.example.bioskopProj.entity.Korisnik;
import com.example.bioskopProj.repository.GledaocRepository;

@Service
public class GledaocService {
	@Autowired
	private GledaocRepository gledaocRepository;
	
	
		public Gledaoc save(Gledaoc gledaoc) {
			return this.gledaocRepository.save(gledaoc);
		}
		
		public Gledaoc find(String userName,String password) {
			Gledaoc g=this.gledaocRepository.findByUserNameAndPassword(userName, password);

			return g;
		}
		
		public Gledaoc registracija(Korisnik g) {
			Gledaoc gledaoc=new Gledaoc();
			gledaoc.setUserName(g.getUserName());
			gledaoc.setPassword(g.getPassword());
			gledaoc.setName(g.getName());
			gledaoc.setSurname(g.getSurname());
			gledaoc.setContactTel(g.getContactTel());
			gledaoc.setDate(g.getDate());
			gledaoc.setEmail(g.getEmail());
			gledaoc.setRole("Gledaoc");
			gledaoc.setActive(true);
			
			return this.gledaocRepository.save(gledaoc);
			
		}
		
}
