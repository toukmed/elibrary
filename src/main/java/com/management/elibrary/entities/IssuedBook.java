package com.management.elibrary.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ISSUED_BOOK")
public class IssuedBook extends AbstractEntity implements Serializable {

    @Column(name = "CALL_NO")
    private String callno;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Student student;
    @OneToOne(cascade = CascadeType.MERGE)
    private Book book;
    @Column(name = "ISSUED_DATE")
    @CreatedDate
    private LocalDate issuedDate;
    @Column(name = "RETURN_STATUS")
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

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate() {
        this.issuedDate = LocalDate.now();
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
}
