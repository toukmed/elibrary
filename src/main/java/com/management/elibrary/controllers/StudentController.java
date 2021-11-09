package com.management.elibrary.controllers;

import com.management.elibrary.dtoconverters.StudentDTO;
import com.management.elibrary.entities.Student;
import com.management.elibrary.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody StudentDTO studentDTO){
        Student student = modelMapper.map(studentDTO, Student.class);
        String createStudent = studentService.createStudent(student);
        return new ResponseEntity(createStudent, HttpStatus.OK);
    }
}
