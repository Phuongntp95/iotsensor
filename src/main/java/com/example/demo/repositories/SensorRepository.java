package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Sensor;



@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

	@Query("select a from Sensor a where a.id = :id")
	public Sensor findBySensorId(@Param("id") int id);
	
	@Query("select a from Sensor a")
	public List<Sensor> findNewSensor();
}
