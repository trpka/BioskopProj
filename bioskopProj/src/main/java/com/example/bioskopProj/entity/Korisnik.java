package com.example.bioskopProj.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Korisnik implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 @Column
	private String password;
	 @Column
	private String name;
	 @Column
	private String surname;
	 @Column
	private String contactTel;
	 @Column
	private String email;
	 @Column
	private String Date;
	 @Column
	private String role;
	 @Column
	private boolean active;
	 @Column
	private String userName;
	 
	 
	public Korisnik()
		{}
	public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String kontaktTelefon,
		String eadresa, String datumRodjenja,String uloga) {
		super();
		this.userName = korisnickoIme;
		this.password= lozinka;
		this.name = ime;
		this.surname = prezime;
		this.contactTel = kontaktTelefon;	
		this.email = eadresa;
		this.Date = datumRodjenja;
		this.role=uloga;
		}
		
	@Override
	public String toString() {
		return super.toString();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}

