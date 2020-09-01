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

import com.example.bioskopProj.entity.Bioskop;
import com.example.bioskopProj.entity.Projekcija;
import com.example.bioskopProj.entitydto.BioskopDTO;
import com.example.bioskopProj.service.BioskopService;
import com.example.bioskopProj.service.ProjekcijaService;



@RestController
@RequestMapping(value="/api")
public class BioskopController {
	
	@Autowired
	private BioskopService bioskopService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@GetMapping(
			value="/pregledBioskopa",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BioskopDTO>> pregledBioskopa(){
		if(KorisnikController.getRole()==2)
		{
			List<Bioskop> bioskopi=this.bioskopService.findAll();
			List<BioskopDTO> bioskopiDTO=new ArrayList<>();
			
			for (Bioskop bioskop : bioskopi) {
				BioskopDTO bioskopDTO=new BioskopDTO(bioskop.getId(),bioskop.getNaziv(),bioskop.getAdresa(),bioskop.getEmail(),bioskop.getBrCentrale());
				bioskopiDTO.add(bioskopDTO);
			}
			
			return new ResponseEntity<>(bioskopiDTO,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(
			value="/obrisiBioskop/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BioskopDTO> obrisi(@PathVariable(name="id") Long id){
		Bioskop bioskop=this.bioskopService.findOne(id);
		
		BioskopDTO bio=new BioskopDTO(bioskop.getId(),bioskop.getNaziv(),bioskop.getAdresa(),bioskop.getEmail(),bioskop.getBrCentrale());
		this.bioskopService.delete(id);
		
		return new ResponseEntity<>(bio,HttpStatus.OK);
	}
	
	 @PostMapping(
				value="/dodavanjeBioskopa",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Bioskop> registracija(@RequestBody Bioskop b) throws Exception{
		 if(KorisnikController.getRole()==3)
			{
			 Bioskop bioskop = new Bioskop(b.getId(),b.getNaziv(),b.getAdresa(),b.getEmail(),b.getBrCentrale());
				Bioskop bio = this.bioskopService.saveBioskop(bioskop);
				return new ResponseEntity<>(bio,HttpStatus.OK);
			}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	 @PostMapping(
				value="/kreiranjeRasporeda",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Projekcija> dodajRaspored(@RequestBody Projekcija p) throws Exception{
		 if(KorisnikController.getRole()==2)
			{
			 Projekcija projekcija = new Projekcija(p.getId(),p.getDan(),p.getVreme(),p.getCena());
				
				
				return new ResponseEntity<>(this.projekcijaService.saveProjekcija(projekcija),HttpStatus.OK);
			}
		 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	
	 @GetMapping(
				value="/rezervacijaKarata",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Projekcija>> pregledKarata(){
		 if(KorisnikController.getRole()==1)
			{
			 List<Projekcija> projekcije=this.projekcijaService.findSlobodne();
			 return new ResponseEntity<>(projekcije,HttpStatus.OK);
			}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 
	 @GetMapping(
				value="/pregledRezervisanih",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Projekcija>> pregledRezervisanih(){
		 if(KorisnikController.getRole()==1)
			{
			 List<Projekcija> projekcije=this.projekcijaService.findRezervisane();
			 return new ResponseEntity<>(projekcije,HttpStatus.OK);
			}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }

	 @GetMapping(
				value="/izmenaRasporedaa",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Projekcija>> pregledRasporeda(){
		 if(KorisnikController.getRole()==2)
			{
			 List<Projekcija> projekcije=this.projekcijaService.findAll();
			 return new ResponseEntity<>(projekcije,HttpStatus.OK);
			}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 
	 @GetMapping(
				value="izmeniRaspored/{id}",
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Projekcija> izmeniRaspored(@PathVariable(name="id") Long id){
			Projekcija proj=this.projekcijaService.findOne(id);
			if(proj==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			Projekcija p = new Projekcija();
			p.setId(proj.getId());
			p.setCena(proj.getCena());
			p.setDan(proj.getDan());
			p.setVreme(proj.getVreme());
			
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
	 
	 @PostMapping(
				value="/izmenaRasp",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE
				)
			public ResponseEntity<Projekcija> izmenaSale(@RequestBody Projekcija p) throws Exception{
				Projekcija proj = this.projekcijaService.findOne(p.getId());
				if(proj==null) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				proj.setDan(p.getDan());
				proj.setVreme(p.getVreme());
				proj.setCena(p.getCena());
				this.projekcijaService.saveProjekcija(proj);
				Projekcija ret = new Projekcija();
				ret.setId(proj.getId());
				
				return new ResponseEntity<>(ret,HttpStatus.OK);
			}
	 
	 @GetMapping(
				value="izmeniBioskop/{id}",
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Bioskop> sala(@PathVariable(name="id") Long id){
			Bioskop bioskop=this.bioskopService.findOne(id);
			if(bioskop==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			Bioskop b = new Bioskop();
			b.setId(bioskop.getId());
			b.setNaziv(bioskop.getNaziv());
			b.setAdresa(bioskop.getAdresa());
			b.setEmail(bioskop.getEmail());
			b.setBrCentrale(bioskop.getBrCentrale());
			
			return new ResponseEntity<>(b,HttpStatus.OK);
		}
	 
	 @PostMapping(
				value="/izmenaBioskop",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE
				)
			public ResponseEntity<Bioskop> izmenaBioskop(@RequestBody Bioskop b) throws Exception{
		 Bioskop bio = this.bioskopService.findOne(b.getId());
				if(bio==null) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				bio.setNaziv(b.getNaziv());
				bio.setAdresa(b.getAdresa());
				bio.setBrCentrale(b.getBrCentrale());
				bio.setEmail(b.getEmail());
				this.bioskopService.saveBioskop(bio);
				Bioskop ret = new Bioskop();
				ret.setId(bio.getId());
				return new ResponseEntity<>(ret,HttpStatus.OK);
			}
}
