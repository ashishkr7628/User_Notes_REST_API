package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.PersonDao;
import com.org.dto.Person;
import com.org.repository.IdNotFoundException;
@CrossOrigin
@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	PersonDao dao;
	
	@PostMapping
	public Person save(@RequestBody Person person) {
		
		return   dao.save(person);
		  
		 
		  
		
		
		
		
	}
	
	@RequestMapping
	public  ResponseEntity<List<Person>> fetchAll() {
		
		  List<Person> list = dao.findAll();
		  
		  
		 return new ResponseEntity<List<Person>>(list,HttpStatus.OK);
		  
		
		
		
		
		
	}
	
	
	@RequestMapping("/{id}")
	public ResponseEntity<Person> fetchById(@PathVariable int id) {
		
		  Person person = dao.findById(id);
		  
		  if(person!=null) {
			  
			  return new ResponseEntity<Person>(person,HttpStatus.OK);
		  }
		  
//		  else {
//			  
////			  return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
//		  }
		
		throw new IdNotFoundException("Id not Found");
		
		
	}
	
	

	
	@DeleteMapping("/delete")
	
	public void deletePerson(@RequestBody Person person) {
		
		 dao.delete(person);
		
		
		
		
	}
	
	@DeleteMapping("/deleteById/{id}")
	
	public void deletePerson(@PathVariable int id) {
		
		 dao.deleteById(id);
		
		
		
		
	}
	
	
	
	
	

}
