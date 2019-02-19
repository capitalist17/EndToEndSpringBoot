package com.etoe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etoe.entities.Location;

//Change this from CRUDRepository to JpaRepository as findAll method in CRUDRepository returns an iterable.
//If you want a method that returns a List then use JpaRepository. JpaRepository is a sub interface of CRUDRepo.
public interface LocationRepository extends JpaRepository<Location, Long>{

}
