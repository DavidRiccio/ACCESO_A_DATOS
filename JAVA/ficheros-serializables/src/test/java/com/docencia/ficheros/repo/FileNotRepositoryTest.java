package com.docencia.ficheros.repo;

import org.junit.jupiter.api.Test;

import com.docencia.ficheros.repo.FileNoteRepository;

class FileNotRepositoryTest {
FileNoteRepository fileNoteRepository;

@Test 
void createFileTest(){
    fileNoteRepository = new FileNoteRepository();
}
}
