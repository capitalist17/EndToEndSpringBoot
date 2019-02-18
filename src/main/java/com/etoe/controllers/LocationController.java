package com.etoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoe.entities.Location;
import com.etoe.services.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService locService;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap ) {
		Location savedLoc = locService.saveLocation(location);
		String msg = "Location saved with id: " + savedLoc.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}
}
