package com.justinsmith.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.justinsmith.dojosandninjas.models.Dojo;
import com.justinsmith.dojosandninjas.models.Ninja;
import com.justinsmith.dojosandninjas.services.DojoNinjaServices;

@Controller
public class DojoNinjaController {
	@Autowired
	private DojoNinjaServices dojoServices;
	
	@Autowired
	private DojoNinjaServices ninjaServices;
	
	@RequestMapping("dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		return "/dojos/newDojo.jsp";
	}
	
	@RequestMapping(value="/newDojo", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/dojos/newDojo.jsp";
		} else {
			dojoServices.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServices.allDojos();
		model.addAttribute("dojos", dojos);
		return "/dojos/newNinja.jsp";
	}
	
	@RequestMapping(value="/newNinja", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/dojos/newNinja.jsp";
		} else {
			ninjaServices.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String viewDojos(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServices.findDojoById(id);
		model.addAttribute("dojo", dojo);
		List<Ninja> ninja = ninjaServices.ninjaById(id);
		model.addAttribute("ninjas", ninja);
		return "/dojos/dojos.jsp";
	}
	
	

}
