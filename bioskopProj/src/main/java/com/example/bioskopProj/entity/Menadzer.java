package com.example.bioskopProj.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
public class Menadzer extends Korisnik implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Bioskop> bioskopi = new HashSet<>();

	public Set<Bioskop> getBioskopi() {
		return bioskopi;
	}

	public void setBioskopi(Set<Bioskop> bioskopi) {
		this.bioskopi = bioskopi;
	}
}
