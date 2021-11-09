package com.management.elibrary.repositories;

import com.management.elibrary.entities.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class StudentRepository extends AbstractRepository{

    public static final String STUDENT_CREATED_SUCCESSFULLY = "Student created successfully";
    public static final String STUDENT_ALREADY_EXIST = "Student already exist";
    public static final String FIND_STUDENT_BY_NAME = "from Student s where s.name ='";

    public String createStudent(Student studentRequest){
        try{
            Student student = (Student) entityManager
                    .createQuery(FIND_STUDENT_BY_NAME +studentRequest.getName()+"'")
                    .getSingleResult();
            if(student == null){
                entityManager.persist(studentRequest);
                return STUDENT_CREATED_SUCCESSFULLY;
            }else{
                return STUDENT_ALREADY_EXIST;
            }
        }catch (NoResultException ex){
            entityManager.persist(studentRequest);
            return STUDENT_CREATED_SUCCESSFULLY;
        }
    }
}
