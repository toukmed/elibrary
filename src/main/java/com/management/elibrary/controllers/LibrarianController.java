package com.management.elibrary.controllers;

import com.management.elibrary.dtoconverters.LibrarianDTO;
import com.management.elibrary.entities.Librarian;
import com.management.elibrary.services.LibrarianService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {

    public static final String DELETED_SUCCESSFULLY = "Librarian deleted successfully";
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LibrarianService librarianService;

    @PostMapping(path = "/create")
    public ResponseEntity createLibrarian(@Valid @RequestBody LibrarianDTO librarianDTO){
        Librarian librarian = modelMapper.map(librarianDTO, Librarian.class);
        String createMessage = librarianService.createLibrarian(librarian);
        return new ResponseEntity(createMessage, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<LibrarianDTO> updateLibrarian(@PathVariable(name = "id") Long id, @RequestBody LibrarianDTO librarianDTO){
        Librarian librarian = librarianService
                .updateLibrarian(id, modelMapper.map(librarianDTO, Librarian.class));
        return ResponseEntity.ok().body(modelMapper.map(librarian, LibrarianDTO.class));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable(name = "id") Long id){
        librarianService.deleteLibrarian(id);
        return new ResponseEntity(DELETED_SUCCESSFULLY, HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<LibrarianDTO> getLibrarian(@PathVariable(name = "id") Long id){
        Librarian librarian =  librarianService.getLibrarian(id);
        return ResponseEntity
                .ok()
                .body(modelMapper.map(librarian, LibrarianDTO.class));
    }

    @GetMapping(path = "/get")
    public List<LibrarianDTO> getLibrarians(){
        return librarianService
                .getLibrarians()
                .stream()
                .map(librarian -> modelMapper.map(librarian, LibrarianDTO.class))
                .collect(Collectors.toList());
    }
}
