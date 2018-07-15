package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Bomnuoc;


@Repository
public interface BomnuocRepository extends JpaRepository<Bomnuoc, Integer> {
	
	@Query("select a from Bomnuoc a where a.id = :id")
	public Bomnuoc findByUserId(@Param("id") int id);
}
