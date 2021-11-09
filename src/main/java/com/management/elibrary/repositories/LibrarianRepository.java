package com.management.elibrary.repositories;

import com.management.elibrary.entities.Librarian;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class LibrarianRepository extends AbstractRepository{

    public static final String FIND_ALL_LIBRARIANS = "from Librarian";
    public static final String FIND_LIBRARIAN_BY_EMAIL = "from Librarian l where l.email ='";
    public static final String LIBRARIAN_CREATED = "Librarian created";
    public static final String LIBRARIAN_ALREADY_EXIST = "Librarian already exist";

    public String createLibrarian(Librarian librarian){
        try{
            Librarian librarianCheck = (Librarian) entityManager
                    .createQuery(FIND_LIBRARIAN_BY_EMAIL + librarian.getEmail()+"'")
                    .getSingleResult();
            if(librarianCheck == null){
                entityManager.persist(librarian);
                return LIBRARIAN_CREATED;
            }else{
                return LIBRARIAN_ALREADY_EXIST;
            }
        }catch (NoResultException ex){
            entityManager.persist(librarian);
            return LIBRARIAN_CREATED;
        }

    }

    public Librarian updateLibrarian(Librarian librarian){
        return entityManager.merge(librarian);
    }

    public void deleteLibrarian(Long id){
        Librarian librarian = entityManager.find(Librarian.class, id);
        entityManager.remove(librarian);
    }

    public Librarian getLibrarian(Long id){
        return entityManager.find(Librarian.class, id);
    }

    public List<Librarian> getLibrarians(){
        return (List<Librarian>) entityManager.createQuery(FIND_ALL_LIBRARIANS).getResultList();

    }
}
