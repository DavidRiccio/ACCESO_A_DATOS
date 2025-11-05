package com.docencia.repo.jpa;

import com.docencia.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface ISqliteNoteRepository extends JpaRepository<Note, String> {
  
}