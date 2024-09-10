package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.dto.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
	


}
