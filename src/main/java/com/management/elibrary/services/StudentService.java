package com.management.elibrary.services;

import com.management.elibrary.entities.Student;
import com.management.elibrary.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public String createStudent(Student student){
        return studentRepository.createStudent(student);
    }
}
