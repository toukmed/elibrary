package com.management.elibrary.controllers;

import com.management.elibrary.dtoconverters.BookDTO;
import com.management.elibrary.dtoconverters.IssuedBookDTO;
import com.management.elibrary.entities.Book;
import com.management.elibrary.entities.IssuedBook;
import com.management.elibrary.services.BookService;
import com.management.elibrary.services.IssuedBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("books")
public class BookController {

    public static final String BOOK_DELETED_SUCCESSFULLY = "Book deleted successfully";
    @Autowired
    private BookService bookService;
    @Autowired
    private IssuedBookService issuedBookService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    public ResponseEntity createBook(@RequestBody BookDTO bookDTO){
        Book book = modelMapper.map(bookDTO, Book.class);
        String createMessage = bookService.createBook(book);
        return new ResponseEntity(createMessage, HttpStatus.OK);
    }

    @DeleteMapping("delete/{callno}")
    public ResponseEntity deleteBook(@PathVariable(name = "callno") String callno){
        bookService.deleteBook(callno);
        return new ResponseEntity(BOOK_DELETED_SUCCESSFULLY, HttpStatus.OK);
    }

    @PutMapping("/update/{callno}")
    public ResponseEntity updateBook(@PathVariable(name = "callno") String callno, @RequestBody BookDTO bookDTO){
        Book book = modelMapper.map(bookDTO, Book.class);
        bookService.updateBook(callno, book);
        return ResponseEntity.ok().body(bookDTO);
    }

    @GetMapping("/get/{callno}")
    public ResponseEntity getBook(@PathVariable(name = "callno") String callno){
        Book book = bookService.getBookByCallNo(callno);
        return ResponseEntity
                .ok()
                .body(modelMapper.map(book, BookDTO.class));
    }

    @GetMapping("/get")
    public List<BookDTO> getAllBooks(){
        return bookService
                .getAllBooks()
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .distinct()
                .collect(Collectors.toList());
    }

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestBody IssuedBookDTO issuedBookDTO){
        IssuedBook issuedBook = modelMapper.map(issuedBookDTO, IssuedBook.class);
        String issueBookMessage = issuedBookService.issueBook(issuedBook);
        return new ResponseEntity(issueBookMessage, HttpStatus.OK);
    }
}
