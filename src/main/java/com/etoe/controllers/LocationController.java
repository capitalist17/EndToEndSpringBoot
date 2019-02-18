package com.etoe.controllers;

import java.util.List;

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
		// @ModelAttribute binds all the input fields in the JSP to the location object using the Location Model
		// before entering the method body. ModelMap is used to send response back to the JSP page
		Location savedLoc = locService.saveLocation(location);
		String msg = "Location saved with id: " + savedLoc.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = locService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
}
