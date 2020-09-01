package com.example.bioskopProj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bioskopProj.entity.Film;


public interface FilmRepository extends JpaRepository<Film, Long>{
	List<Film> findAllByOrderByOcenaDesc();
}
