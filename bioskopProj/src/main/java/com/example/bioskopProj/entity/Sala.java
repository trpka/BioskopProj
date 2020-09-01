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


@Entity
public class Sala implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private int kapacitet;
	@Column
	private String oznaka;
	
	public Sala()
	{
		
	}

	public Sala(long id, int kapacitet, String oznaka) {
		super();
		this.id = id;
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
	}
	
	@ManyToMany
   @JoinTable(name = "terminska_lista_projekcija",
   joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
   inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
	private Set<Projekcija> lista_projekcija = new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Bioskop bioskop;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public Set<Projekcija> getProjekcije() {
		return lista_projekcija;
	}
	public void setProjekcije(Set<Projekcija> projekcije) {
		this.lista_projekcija = projekcije;
	}
}
