package com.management.elibrary.dtoconverters;

public class BookDTO {

    private String callno;
    private String name;
    private String author;
    private String publisher;
    private Integer quantity;
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

}
