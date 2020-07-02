package com.justinsmith.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.justinsmith.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	//retrieves all Ninjas from database
	List<Ninja> findAll();
	
	//finds ninjas by last name contining search string
	List<Ninja> findByLastNameContaining(String search);
	
	List<Ninja> findByDojoId(Long id);
}

