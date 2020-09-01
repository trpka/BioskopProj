package com.example.bioskopProj.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Projekcija implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String dan;
	@Column
	private String vreme;
	@Column
	private int cena;
	@Column
	private int brojRezervacija;
	@Column
	private boolean rezervisan;
	
	public Projekcija()
	{
		
	}
	
	public Projekcija(long id, String dan, String vreme, int cena) {
		super();
		this.id = id;
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.brojRezervacija = 0;
		this.rezervisan = false;
	}
	
	@ManyToOne
	@JoinColumn
	private Film film;
	
	@ManyToMany(mappedBy = "projekcije")
	private Set<Bioskop> bioskopi = new HashSet<>();
	
	@ManyToMany(mappedBy = "lista_projekcija")
	private Set<Sala> sale = new HashSet<>();
	
	public String getDan() {
		return dan;
	}
	public void setDan(String dan) {
		this.dan = dan;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getBrojRezervacija() {
		return brojRezervacija;
	}
	public void setBrojRezervacija(int brojRezervacija) {
		this.brojRezervacija = brojRezervacija;
	}
	
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public boolean isRezervisan() {
		return rezervisan;
	}
	public void setRezervisan(boolean rezervisan) {
		this.rezervisan = rezervisan;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
