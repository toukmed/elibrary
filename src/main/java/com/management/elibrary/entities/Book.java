package com.management.elibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOOK")
public class Book extends AbstractEntity implements Serializable {

    @Column(name = "CALL_NO")
    private String callno;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "PUBLISHER")
    private String publisher;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "ISSUED")
    private Integer issued;

    public String getCallno() {
        return callno;
    }

    public void setCallno(String callno) {
        this.callno = callno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIssued() {
        return issued;
    }

    public void setIssued(Integer issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "Book{" +
                "callno='" + callno + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                ", quantity=" + quantity +
                '}';
    }
}
