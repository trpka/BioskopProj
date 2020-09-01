package com.example.bioskopProj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bioskopProj.entity.Administrator;
import com.example.bioskopProj.entity.Gledaoc;
import com.example.bioskopProj.entity.Korisnik;
import com.example.bioskopProj.entity.Menadzer;
import com.example.bioskopProj.service.AdministratorService;
import com.example.bioskopProj.service.GledaocService;
import com.example.bioskopProj.service.MenadzerService;

@RestController
@RequestMapping(value="/api")
public class KorisnikController {
		
	@Autowired
	private GledaocService gledaocService;
	
	@Autowired
	private MenadzerService menadzerService;
	
	@Autowired
	private AdministratorService administratorService;
	
	public static int role=1; 
	 
	 public static int getRole() {
		return role;
	}

	public static void setRole(int role) {
		KorisnikController.role = role;
	}
	
	@PostMapping(
			value="/prijava",
			consumes = MediaType.APPLICATION_JSON_VALUE,     
	        produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Korisnik> prijava(@RequestBody Korisnik korisnik) throws Exception{
			Gledaoc g=this.gledaocService.find(korisnik.getUserName(),korisnik.getPassword());
			Menadzer m=this.menadzerService.find(korisnik.getUserName(),korisnik.getPassword());
			Administrator a=this.administratorService.find(korisnik.getUserName(),korisnik.getPassword());
			if(g!=null && g.isActive()==true) {
				role=1;
				Korisnik povratna=new Korisnik(g.getUserName(),g.getPassword(),g.getName(),g.getSurname(),g.getContactTel(),g.getEmail(),g.getDate(),g.getRole());
				return new ResponseEntity<>(povratna,HttpStatus.OK);
			}else if(m!=null && m.isActive()==true) {
				role=2;
				Korisnik povratna=new Korisnik(m.getUserName(),m.getPassword(),m.getName(),m.getSurname(),m.getContactTel(),m.getEmail(),m.getDate(),m.getRole());
				return new ResponseEntity<>(povratna,HttpStatus.OK);
			}else if(a!=null && a.isActive()==true) {
				role=3;
				Korisnik povratna=new Korisnik(a.getUserName(),a.getPassword(),a.getName(),a.getSurname(),a.getContactTel(),a.getEmail(),a.getDate(),a.getRole());
				return new ResponseEntity<>(povratna,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

	@PostMapping(
				value="/registracija",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Korisnik> registracija(@RequestBody Korisnik k) throws Exception{
				Korisnik korisnik=new Korisnik(k.getUserName(),k.getPassword(),k.getName(),k.getSurname(),k.getContactTel(),k.getEmail(),k.getDate(),k.getRole());
				Korisnik noviKorisnik=gledaocService.registracija(korisnik);
				return new ResponseEntity<>(noviKorisnik,HttpStatus.OK);
			}
	 
	
		@PostMapping(
				value="/registracijaMenadzera",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Korisnik> registracijaMen(@RequestBody Korisnik kor) throws Exception{
			if(role==3)
			{
				Korisnik korisnik=new Korisnik(kor.getUserName(),kor.getPassword(),kor.getName(),kor.getSurname(),kor.getContactTel(),kor.getEmail(),kor.getDate(),kor.getRole());
				Korisnik noviKorisnik=menadzerService.registracija(korisnik);
				return new ResponseEntity<>(noviKorisnik,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
}
