package com.example.bioskopProj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioskopProj.entity.Film;
import com.example.bioskopProj.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	public Film findOne(Long id) {
		Film film=this.filmRepository.getOne(id);
		return film;
	}
	
	public List<Film> findAll(){
		List<Film> film=this.filmRepository.findAll();
		return film;
	}
	
	public Film saveFilm(Film f)
	{
		return this.filmRepository.save(f);
	}
	
	public List<Film> findOdgledaniNeocenjeni(){
		List<Film> filmovi=this.filmRepository.findAll();
		List<Film> povratna = new ArrayList<>();
		for (Film film : filmovi) {
			if(film.isOdgledan()==true && film.getOcena()==0)
			{
				povratna.add(film);
			}	
		}
		return povratna;
	}
	
	public List<Film> findOdgledaniOcenjeni(){
		List<Film> filmovi=this.filmRepository.findAll();
		List<Film> povratna = new ArrayList<>();
		for (Film film : filmovi) {
			if(film.isOdgledan()==true && film.getOcena()!=0)
			{
				povratna.add(film);
			}	
		}
		return povratna;
	}
	
	public List<Film> findOdgledani(){
		List<Film> filmovi=this.filmRepository.findAll();
		List<Film> odgledani = new ArrayList<>();
		for (Film film : filmovi) {
			if(film.isOdgledan()==true)
			{
				odgledani.add(film);
			}	
		}
		return odgledani;
	}
}
