package com.example.bioskopProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioskopProj.entity.Korisnik;
import com.example.bioskopProj.repository.KorisnikRepository;

@Service
public class KorisnikService {
	@Autowired
    private KorisnikRepository korisnikRepository;
	
	public Korisnik saveKorisnik(Korisnik korisnik) {
    	return this.korisnikRepository.save(korisnik);
    }

	public List<Korisnik> findAll() {
		List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
	}
}
