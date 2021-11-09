package com.management.elibrary.services;

import com.management.elibrary.entities.IssuedBook;
import com.management.elibrary.repositories.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    @Transactional
    public String issueBook(IssuedBook issuedBook) {
        return issuedBookRepository.issueBook(issuedBook);
    }
}
