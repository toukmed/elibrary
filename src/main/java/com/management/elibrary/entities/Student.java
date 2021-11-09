package com.management.elibrary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
public class Student extends AbstractEntity implements Serializable {

    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE")
    private Integer phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
