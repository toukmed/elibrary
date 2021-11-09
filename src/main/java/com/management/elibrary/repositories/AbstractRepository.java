package com.management.elibrary.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class AbstractRepository {
    @PersistenceContext
    protected EntityManager entityManager;

}
