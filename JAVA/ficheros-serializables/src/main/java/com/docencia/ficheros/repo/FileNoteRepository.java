package com.docencia.ficheros.repo;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.docencia.ficheros.model.Note;

public class FileNoteRepository implements INoteRepository {
    private String name;

    public FileNoteRepository() {
        this.name = "note-repository.txt";
        try {
            verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * Si existe y no es un directorio,
     * Si no existe lo creas.
     */

    private void verificarFichero() throws IOException {
        URL resource;
        resource = getClass().getClassLoader().getResource(name);
        if (resource == null) {
            throw new IOException("El fichero no existe" + name);
            /* file.cresateNewFile(); */
        }
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
