package com.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.dto.Notes;
import com.org.repository.NotesRepository;

@Component
public class NotesDao {
	
	
	
	@Autowired
	
	NotesRepository repo;
	
	public  Notes save(Notes notes) {
		
		 return repo.save(notes);
	}
	
	public List<Notes> fetchall() {
	
	return repo.findAll();
	
	
	
	}
	
	
	public Notes fetchById(int id) {
		
		  Optional<Notes> optional = repo.findById(id);
		  
		   return optional.orElse(null);
		
	}
	
	
	public void delete(Notes notes) {
		
		repo.delete(notes);
		
		
	}

}
