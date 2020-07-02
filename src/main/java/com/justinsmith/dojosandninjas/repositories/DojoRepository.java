package com.justinsmith.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.justinsmith.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
//	//retrieves all Dojos  from database
//	List<Dojo> findAll();
//	
//	//finds dojos by location
//	List<Dojo> findByLocationContaining(String search);
	
	
	//get all the Dojos
	@Query("SELECT d FROM Dojo d")
	List<Dojo> findAllDojos();
	
	//get all the names of the dojos
	@Query("SELECT d.name FROM Dojo d")
	List<String> findAllDojosNames();
	
	//passing params and filtering (still retrieves a list)
	@Query("SELECT d FROM Dojo d WHERE id = ?1")
	List<Dojo> getDojoWhereId(Long id);
	
	//passing params and filtering
	@Query("SELECT d FROM Dojo d WHERE id = ?1")
	Dojo getSingleDojoWhereId(Long id);
	
}
