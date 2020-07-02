package com.justinsmith.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justinsmith.dojosandninjas.models.Dojo;
import com.justinsmith.dojosandninjas.models.Ninja;
import com.justinsmith.dojosandninjas.repositories.DojoRepository;
import com.justinsmith.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoNinjaServices {
	
	@Autowired
	private DojoRepository dojoRepository;
	
	@Autowired 
	private NinjaRepository ninjaRepository;
	
	//return all Ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja ninja){
		return ninjaRepository.save(ninja);
	}
	
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}
	
	public List<Ninja> ninjaById(Long id){
		return ninjaRepository.findByDojoId(id);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
	
	//return all Dojos
		public List<Dojo> allDojos(){
			return dojoRepository.findAllDojos();
		}
		
		public Dojo createDojo(Dojo dojo){
			return dojoRepository.save(dojo);
		}
		
		public Dojo findDojoById(Long id) {
			Optional<Dojo> dojo = dojoRepository.findById(id);
			if(dojo.isPresent()) {
				return dojo.get();
			} else {
				return null;
			}
		}
		
		public void deleteDojo(Long id) {
			dojoRepository.deleteById(id);
		}
}
