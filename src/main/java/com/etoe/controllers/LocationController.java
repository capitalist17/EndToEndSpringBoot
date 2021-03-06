package com.etoe.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etoe.entities.Location;
import com.etoe.repos.LocationRepository;
import com.etoe.services.LocationService;
import com.etoe.util.EmailUtil;
import com.etoe.util.ReportUtil;

@Controller
public class LocationController {
	@Autowired
	LocationService locService;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ServletContext sc;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	LocationRepository locRepository;
	
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
		// You can sent email to any account. But we will be using the one which we have created for testing
		emailUtil.sendEmail("asnspring@gmail.com", "Location Saved", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = locService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") Long id, ModelMap modelMap) {
		// Fetch the location object
		//Location location = locService.getLocationById(id); //this makes a DB call which can be avoided
		
		// Alternate efficient method
		Location location  = new Location();
		location.setId(id);
		
		// Delete the location object
		locService.deleteLocation(location);
		
		// Return the new list
		List<Location> locations = locService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String updateLocation(@RequestParam("id") Long id, ModelMap modelMap) {
		Location location = locService.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap ) {
		locService.updateLocation(location);
		// Return the new list
		List<Location> locations = locService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		List<Object[]> data = locRepository.findTypeAndTypeCount();
		String path = sc.getRealPath("/");
		reportUtil.generatePieChart(path, data);
		return "report";
	}
}
