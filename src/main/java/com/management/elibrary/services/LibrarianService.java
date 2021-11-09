package com.management.elibrary.services;

import com.management.elibrary.entities.Librarian;
import com.management.elibrary.repositories.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Transactional
    public String createLibrarian(Librarian librarian){
        return librarianRepository.createLibrarian(librarian);
    }

    public Librarian updateLibrarian(Long id, Librarian librarianRequest){
        Librarian librarian = librarianRepository.getLibrarian(id);
        if(librarian != null) {
            librarian.setName(librarianRequest.getName());
            librarian.setEmail(librarianRequest.getEmail());
            librarian.setPassword(librarianRequest.getPassword());
            librarian.setPhone(librarianRequest.getPhone());
            return librarianRepository.updateLibrarian(librarian);
        }
        return null;
    }

    @Transactional
    public void deleteLibrarian(Long id){
        librarianRepository.deleteLibrarian(id);
    }

    public Librarian getLibrarian(Long id){
        return librarianRepository.getLibrarian(id);
    }

    public List<Librarian> getLibrarians(){
        return librarianRepository.getLibrarians();
    }
}
