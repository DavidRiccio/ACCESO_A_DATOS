package com.pratica1.repo.file;


import java.util.List;

import com.pratica1.domain.model.file.Note;


public interface INoteRepository {
    public boolean exists(String id);

    public Note findById(String id);
    public Note find(Note note);

    public List<Note> findAll();

    public Note save(Note note);

    public boolean delete(String id);
}

