package com.pedrohjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrohjc.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
}
