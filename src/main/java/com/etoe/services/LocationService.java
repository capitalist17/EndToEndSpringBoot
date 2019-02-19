package com.etoe.services;

import java.util.List;

import com.etoe.entities.Location;

public interface LocationService {
	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationById(Long id);

	List<Location> getAllLocations();
}
