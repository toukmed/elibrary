package com.management.elibrary.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "LIBRARIAN")
public class Librarian extends AbstractEntity implements Serializable {

    @Column(name = "NAME")
    @Size(min = 4, max = 30, message = "The name should be between 4 and 30 characters")
    @NotNull
    private String name;
    @Column(name = "EMAIL")
    @NotNull
    @Pattern(regexp = "[\\w\\d-]+@[\\w]+[.][a-z]+"
            , message = "Votre email est invalid, veuillez saisir un email valid")
    private String email;
    @Column(name = "PASSWORD")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
            , message = "Password must contain at least uppercase and lowercase letters, digits and special characters")
    private String password;
    @Column(name = "PHONE")
    @NotNull
    private Integer phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                '}';
    }
}
