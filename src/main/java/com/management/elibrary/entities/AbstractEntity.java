package com.management.elibrary.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @CreatedDate
    @Column(name = "CREATED_AT")
    private LocalDate creationDate;

    @LastModifiedDate
    @Column(name = "MODIFIED_AT")
    private LocalDate modificationDate;

    public Long getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }
}
