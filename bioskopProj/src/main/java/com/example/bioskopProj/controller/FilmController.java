package com.example.bioskopProj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bioskopProj.entity.Film;
import com.example.bioskopProj.entity.Projekcija;
import com.example.bioskopProj.service.FilmService;
import com.example.bioskopProj.service.ProjekcijaService;

@RestController
@RequestMapping(value="/api")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@GetMapping(
	
			value="/filmoviUPonudi",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Film>> pregledSvihFilmova(){
		if(KorisnikController.getRole()==1)
		{
			List<Film> filmovi=this.filmService.findAll();
			return new ResponseEntity<>(filmovi,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(
			value="/filmoviPretraga",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Film>> pretraga(@RequestBody Film f)throws Exception{
		if(KorisnikController.getRole()==1)
		{
			List <Projekcija> projekcije = this.projekcijaService.findAll();
			List<Film> filmovi = new ArrayList<>();
			for(Projekcija p:projekcije)
			{
				if(f.getNaziv()!="")
					if(p.getFilm().getNaziv().equalsIgnoreCase(f.getNaziv()))
					{
						filmovi.add(p.getFilm());
						
						continue;
					}
				if(f.getOpis()!="")
					if(p.getFilm().getOpis().equalsIgnoreCase(f.getOpis()))
					{
						filmovi.add(p.getFilm());
						continue;
					}
				if(f.getZanr()!="")
					if(p.getFilm().getZanr().equalsIgnoreCase(f.getZanr()))
					{
						filmovi.add(p.getFilm());
						continue;
					}
				if(f.getOcena()!=0)
					if(p.getFilm().getOcena()==(f.getOcena()))
					{
						filmovi.add(p.getFilm());
						continue;
					}	
			}
			if(filmovi.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<>(filmovi,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping(
			value="/pregledOcenjenih",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Film>> odgledaniOcenjeni(){
		if(KorisnikController.getRole()==1)
		{
		List<Film> filmovi=this.filmService.findOdgledaniOcenjeni();
		return new ResponseEntity<>(filmovi,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(
			value="/pregledOdgledanih",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Film>> odgledaniFilmovi(){
		if(KorisnikController.getRole()==1)
		{
			List<Film> filmovi=this.filmService.findOdgledani();
			return new ResponseEntity<>(filmovi,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(
			value="/pregledNeocenjenih",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Film>> odgledaniNeocenjeni(){
		if(KorisnikController.getRole()==1)
		{
			List<Film> filmovi=this.filmService.findOdgledaniNeocenjeni();
			return new ResponseEntity<>(filmovi,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(
			value = "/rezervisi/{id}",
	        produces = MediaType.APPLICATION_JSON_VALUE)  
		public ResponseEntity<Projekcija> rezervisi(@PathVariable(name="id") Long id){
		
			Projekcija proj = this.projekcijaService.findOne(id);
			proj.setRezervisan(true);
			
			Projekcija ret = new Projekcija();
			ret.setId(proj.getId());
			return new ResponseEntity<>(ret,HttpStatus.OK);
		}
	
	@PostMapping(
			value="/potvrdiRezervaciju",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
		public ResponseEntity<Projekcija> potvrdiRezervaciju(@RequestBody Projekcija p) throws Exception{
		Projekcija proj = this.projekcijaService.findOne(p.getId());
			if(proj==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			proj.setRezervisan(true);
			this.projekcijaService.saveProjekcija(proj);
			
			Projekcija ret = new Projekcija();
			ret.setId(proj.getId());
			return new ResponseEntity<>(ret,HttpStatus.OK);
		}
	
	@GetMapping(
			value = "/otkazi/{id}",
	        produces = MediaType.APPLICATION_JSON_VALUE)  
		public ResponseEntity<Projekcija> otkazi(@PathVariable(name="id") Long id){
		
			Projekcija proj = this.projekcijaService.findOne(id);
			proj.setRezervisan(false);
			
			Projekcija ret = new Projekcija();
			ret.setId(proj.getId());
			return new ResponseEntity<>(ret,HttpStatus.OK);
		}
	
	@PostMapping(
			value="/otkaziRezervaciju",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
		public ResponseEntity<Projekcija> otkaziRezervaciju(@RequestBody Projekcija p) throws Exception{
		Projekcija proj = this.projekcijaService.findOne(p.getId());
			if(proj==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			proj.setRezervisan(false);
			this.projekcijaService.saveProjekcija(proj);
			
			Projekcija ret = new Projekcija();
			ret.setId(proj.getId());
			return new ResponseEntity<>(ret,HttpStatus.OK);
		}
	
	@GetMapping(
			value="oceniFilm/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> sala(@PathVariable(name="id") Long id){
		Film film=this.filmService.findOne(id);
		if(film==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Film f = new Film();
		f.setId(film.getId());
		f.setOcena(film.getOcena());
		return new ResponseEntity<>(f,HttpStatus.OK);
	}
	
	@PostMapping(
			value="/ocena",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
		public ResponseEntity<Film> izmenaSale(@RequestBody Film f) throws Exception{
		Film film = this.filmService.findOne(f.getId());
			if(film==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			film.setOcena(f.getOcena());
			this.filmService.saveFilm(film);
			
			Film ret = new Film();
			ret.setId(film.getId());
			return new ResponseEntity<>(ret,HttpStatus.OK);
		}
}
