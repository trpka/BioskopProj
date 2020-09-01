package com.example.bioskopProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioskopProj.entity.Bioskop;
import com.example.bioskopProj.repository.BioskopRepository;

@Service
public class BioskopService {
	
	@Autowired 
	private BioskopRepository bioskopRepository;
	
	public Bioskop saveBioskop(Bioskop bioskop)
	{
		return this.bioskopRepository.save(bioskop);
	}
	
	public List<Bioskop> findAll() {
		List<Bioskop> bioskopi = this.bioskopRepository.findAll();
        return bioskopi;
	}
	
	public void delete(Long id) {
		this.bioskopRepository.deleteById(id);
	}
	
	public Bioskop findOne(Long id) {
		Bioskop bioskop=this.bioskopRepository.getOne(id);
		return bioskop;
	}
}
