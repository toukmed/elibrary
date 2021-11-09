package com.management.elibrary.repositories;

import com.management.elibrary.entities.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class BookRepository extends AbstractRepository{

    public static final String FIND_BOOK_BY_CALLNO = "from Book b where b.callno = '";
    public static final String BOOK_CREATED_SUCCESSFULLY = "Book created successfully";
    public static final String BOOK_ALREADY_CREATED = "Book already created";
    public static final String FIND_ALL_BOOKS = "from Book b";

    public String createBook(Book book){
        try{
            Book bookCheck = (Book) entityManager
                    .createQuery(FIND_BOOK_BY_CALLNO +book.getCallno()+"'")
                    .getSingleResult();
            if(bookCheck == null){
                entityManager.persist(book);
                return BOOK_CREATED_SUCCESSFULLY;
            }else{
                return BOOK_ALREADY_CREATED;
            }
        }catch(NoResultException e){
            entityManager.persist(book);
            return BOOK_CREATED_SUCCESSFULLY;
        }
    }

    public void deleteBook(String callno){
        Book book = (Book) entityManager
                .createQuery(FIND_BOOK_BY_CALLNO +callno+"'").getSingleResult();
        entityManager.remove(book);
    }

    public void updateBook(Book book){
        entityManager.merge(book);
    }

    public Book getBookByCallNo(String callNo){
        Book book = (Book) entityManager
                .createQuery(FIND_BOOK_BY_CALLNO +callNo+"'")
                .getSingleResult();
        return book;
    }

    public List<Book> getAllBooks(){
        return entityManager
                .createQuery(FIND_ALL_BOOKS)
                .getResultList();
    }
}
