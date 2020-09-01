package com.example.bioskopProj.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Bioskop implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String naziv;
	@Column
	private String adresa;
	@Column
	private String brCentrale;
	@Column
	private String email;
	
	public Bioskop()
	{
		
	}
	public Bioskop(long id, String naziv, String adresa, String brCentrale, String email) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.brCentrale = brCentrale;
		this.email = email;
	}
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Menadzer manager;
	
	
	@OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Sala> sale = new HashSet<>();
	
	@ManyToMany
   @JoinTable(name = "odrz_projekcije",
   joinColumns = @JoinColumn(name = "bioskop_id", referencedColumnName = "id"),
   inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
	private Set<Projekcija> projekcije = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrCentrale() {
		return brCentrale;
	}
	public void setBrCentrale(String brCentrale) {
		this.brCentrale = brCentrale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Sala> getSale() {
		return sale;
	}
	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}
	public Korisnik getManager() {
		return manager;
	}
	public void setManager(Menadzer manager) {
		this.manager = manager;
	}
	public Set<Projekcija> getRaspored() {
		return projekcije;
	}
	public void setRaspored(Set<Projekcija> raspored) {
		this.projekcije = raspored;
	}
}
