package com.example.bioskopProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioskopProj.entity.Sala;
import com.example.bioskopProj.repository.SalaRepository;


@Service
public class SalaService {
	@Autowired
	private SalaRepository salaRepository;
	
	public Sala findOne(Long id) {
        return this.salaRepository.getOne(id);
	}
	
	public Sala saveSala(Sala sala) {
		return this.salaRepository.save(sala);
	}
	
	public void delete(Long id)
	{
		this.salaRepository.deleteById(id);
	}
	
	public List<Sala> findAll(){
		List<Sala> sale=this.salaRepository.findAll();
		return sale;
	}
}
