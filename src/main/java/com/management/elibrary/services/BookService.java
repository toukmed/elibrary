package com.management.elibrary.services;

import com.management.elibrary.entities.Book;
import com.management.elibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public String createBook(Book book){
        return bookRepository.createBook(book);
    }

    @Transactional
    public void deleteBook(String callno){
        bookRepository.deleteBook(callno);
    }

    public void updateBook(String callno, Book bookRequest){
        Book book = bookRepository.getBookByCallNo(callno);
        book.setCallno(bookRequest.getCallno());
        book.setAuthor(bookRequest.getAuthor());
        book.setName(bookRequest.getName());
        book.setPublisher(bookRequest.getPublisher());
        book.setQuantity(bookRequest.getQuantity());
        book.setIssued(bookRequest.getIssued());
        bookRepository.updateBook(book);
    }

    public Book getBookByCallNo(String callno){
        return bookRepository.getBookByCallNo(callno);
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
}
