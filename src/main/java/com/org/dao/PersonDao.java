package com.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.dto.Person;
import com.org.repository.PersonRepository;
@Component
public class PersonDao {
	
	
	@Autowired
	PersonRepository repo;
	
	public Person save(Person person) {
		
		 return repo.save(person);
	}
	
	
	public List<Person> findAll() {
		
		return repo.findAll();
	}
	
	
	public Person findById(int id) {
		
		 Optional<Person> option = repo.findById(id);
		 
		 return option.orElse(null);
	}
	
	
	public void delete(Person person) {
		
		 repo.delete(person);
	}
	
	
	
	public  void deleteById(int id) {
		Person person = findById(id);
		repo.delete(person);
		
		
	}

}
