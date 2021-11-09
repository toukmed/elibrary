package com.management.elibrary.dtoconverters;

import com.management.elibrary.entities.Book;
import com.management.elibrary.entities.Student;

public class IssuedBookDTO {

    private String callno;
    private Student student;
    private Book book;
    private String returnStatus;

    public String getCallno() {
        return callno;
    }

    public void setCallno(String callno) {
        this.callno = callno;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
}
