package com.example.bioskopProj.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Film implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String naziv;
	@Column
	private String opis;
	@Column
	private String zanr;
	@Column
	private double trajanje;
	@Column
	private double ocena;
	@Column
	private boolean odgledan;
	
	public Film()
	{
		
	}
	
	public Film(long id, String naziv, String opis, String zanr, double trajanje, double ocena, boolean odgledan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.zanr = zanr;
		this.trajanje = trajanje;
		this.ocena = ocena;
		this.odgledan = odgledan;
	}

	@ManyToMany(mappedBy = "filmovi")
	private Set<Gledaoc> gledaoci = new HashSet<>();
	
	@ManyToMany(mappedBy = "rezervisani")
	private Set<Gledaoc> gledaoci_rez = new HashSet<>();
	
	@ManyToMany(mappedBy = "ocene")
	private Set<Gledaoc> gledaoci_ocene = new HashSet<>();
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy="film")
	private List<Projekcija> projekcije=new ArrayList<>();
	
	
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
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	public double getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(double trajanje) {
		this.trajanje = trajanje;
	}
	public double getOcena() {
		return ocena;
	}
	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	public boolean isOdgledan() {
		return odgledan;
	}
	public void setOdgledan(boolean odgledan) {
		this.odgledan = odgledan;
	}
}
