package com.example.bioskopProj.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Gledaoc extends Korisnik implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToMany
    @JoinTable(name = "odgledani_filmovi",
    joinColumns = @JoinColumn(name = "gledaoc_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
	private Set<Film> filmovi = new HashSet<>();
	
	@ManyToMany
    @JoinTable(name = "rezervisani_filmovi",
    joinColumns = @JoinColumn(name = "gledaoc_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
	private Set<Film> rezervisani = new HashSet<>();
	
	@ManyToMany
    @JoinTable(name = "ocene_filmova",
    joinColumns = @JoinColumn(name = "gledaoc_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
	private Set<Film> ocene = new HashSet<>(); 

	public Set<Film> getFilmovi() {
		return filmovi;
	}

	public void setFilmovi(Set<Film> filmovi) {
		this.filmovi = filmovi;
	}


	public Set<Film> getRezervisani_filmovi() {
		return rezervisani;
	}

	public void setRezervisani_filmovi(Set<Film> rezervisani_filmovi) {
		this.rezervisani = rezervisani_filmovi;
	}

	public Set<Film> getOcene() {
		return ocene;
	}

	public void setOcene(Set<Film> ocene) {
		this.ocene = ocene;
	}
}
