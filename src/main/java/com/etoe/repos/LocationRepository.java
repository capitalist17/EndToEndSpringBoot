package com.etoe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etoe.entities.Location;

//Change this from CRUDRepository to JpaRepository as findAll method in CRUDRepository returns an iterable.
//If you want a method that returns a List then use JpaRepository. JpaRepository is a sub interface of CRUDRepo.
public interface LocationRepository extends JpaRepository<Location, Long>{
	
	// The query below is called as JPQL. It is not actually run against the DB. Eventually this will
	// be converted to a native DB query.
	@Query("select type, count(type) from location group by type")
	public List<Object[]> findTypeAndTypeCount();	
}
