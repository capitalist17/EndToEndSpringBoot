package com.etoe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoe.entities.Location;
import com.etoe.repos.LocationRepository;
/*
 * @Service specialized form of @Component annotation. Indicates the purpose for which the bean is instantiated.
 * Spring @Service annotation is used with classes that provide some business functionalities. Spring context 
 * will auto-detect these classes when annotation-based configuration and classpath scanning is used.
 * */

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private  LocationRepository repository;
	
	@Override
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		return repository.findAll();
	}

	public LocationRepository getRepository() {
		return repository;
	}

	public void setRepository(LocationRepository repository) {
		this.repository = repository;
	}
	
	
}
