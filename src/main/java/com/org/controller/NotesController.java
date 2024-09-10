package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.NotesDao;
import com.org.dto.Notes;
import com.org.repository.NotesRepository;

@RestController
@RequestMapping("notes")
public class NotesController {
	
	@Autowired
	
	NotesDao dao;
	
	@PostMapping
	
	public Notes save(@RequestBody Notes notes) {
		
		
		 return dao.save(notes);
		
		
		
		
	}
	
	
	@RequestMapping
	
	public List<Notes> fetchall() {
		
		
		 return dao.fetchall();
		
		
		
		
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Notes> fetchById(@PathVariable int id) {
		
		
		Notes notes = dao.fetchById(id);
		
		if(notes!=null) {
		
		
		return new ResponseEntity<Notes>(notes,HttpStatus.OK);
		
		}
		
		else {
			
			
			return  new ResponseEntity<Notes>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		
		
		Notes notes = dao.fetchById(id);
		
		  dao.delete(notes);
		
		
		  
		  
		
		
	}
	
	
	
	
	

}
