package com.etoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") Long id){
		return locRepo.findById(id).get();
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location){
		return locRepo.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location){
		return locRepo.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") Long id){
		locRepo.deleteById(id);
	}
}
