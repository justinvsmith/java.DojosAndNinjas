package com.justinsmith.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justinsmith.dojosandninjas.models.Dojo;
import com.justinsmith.dojosandninjas.models.Ninja;
import com.justinsmith.dojosandninjas.services.DojoNinjaServices;

@RestController
public class DojoNinjaApi {
	@Autowired
	private DojoNinjaServices dojoService;
	
	@Autowired 
	private DojoNinjaServices ninjaService;
	
	@RequestMapping("/api/dojos")
	public List<Dojo> index(){
		return dojoService.allDojos();
	}
	
	@RequestMapping("/api/ninjas")
	public List<Ninja> home(){
		return ninjaService.allNinjas();
	}
	
	@RequestMapping(value="/api/dojos", method=RequestMethod.POST)
	public Dojo create(@RequestParam("location") String location) {
		Dojo dojo = new Dojo(location);
		return dojoService.createDojo(dojo);
	}
	
	@RequestMapping(value="/api/ninjas", method=RequestMethod.POST)
	public Ninja make(@RequestParam("dojo_id") Long id,
					  @RequestParam("firstName") String firstName,
					  @RequestParam("lastName") String lastName,
					  @RequestParam("age") int age) {
		Ninja ninja = new Ninja(firstName, lastName, age);
		return ninjaService.createNinja(ninja);
	}
	
	@RequestMapping(value="/api/dojos/{id}", method=RequestMethod.GET)
	public Dojo show(@PathVariable("id") Long id) {
		Dojo dojo = dojoService.findDojoById(id);
		return dojo;
	}
	
	@RequestMapping(value="/api/ninjas/{id}", method=RequestMethod.GET)
	public Ninja list(@PathVariable("id") Long id) {
		Ninja ninja = ninjaService.findNinjaById(id);
		return ninja;
	}
}
