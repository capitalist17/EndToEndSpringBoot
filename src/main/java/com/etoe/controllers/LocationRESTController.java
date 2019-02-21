package com.etoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etoe.entities.Location;
import com.etoe.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
	
	@Autowired
	LocationRepository locRepo;
	
	@GetMapping
	public List<Location> getLocations(){
		return locRepo.findAll();
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location){
		return locRepo.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location){
		return locRepo.save(location);
	}
}
