package com.management.elibrary.repositories;

import com.management.elibrary.entities.IssuedBook;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class IssuedBookRepository extends AbstractRepository{

    public static final String BOOK_ISSUED_SUCCESSFULLY = "Book issued successfully to student :";
    public static final String FIND_ISSUEBOOK_BY_CALLNO = "from IssuedBook b where b.callno = '";
    public static final String YES_RETURN_STATUS = "YES";
    public static final String NO_RETURN_STATUS = "NO";
    public static final String BOOK_NOT_ISSUED_FOR_REASONS = "Could not issue Book : {} for those reasons [Return status : %s, Quantity : %s";
    public static final String BOOK_ALREADY_ISSUED = "Book : %s, already issued to student : %s";

    public String issueBook(IssuedBook issuedBookRequest){
        try{
            IssuedBook issuedBook = (IssuedBook) entityManager
                    .createQuery(FIND_ISSUEBOOK_BY_CALLNO +issuedBookRequest.getCallno()+"'")
                    .getSingleResult();

            if(issuedBook == null){
                return issueBookAfterCheck(issuedBookRequest);
            }else{
                return String.format(BOOK_ALREADY_ISSUED
                        , issuedBook.getBook().getCallno()
                        , issuedBook.getStudent().getName());
            }
        }catch (NoResultException ex){
            return issueBookAfterCheck(issuedBookRequest);
        }
    }

    private String issueBookAfterCheck(IssuedBook issuedBookRequest) {
        if(NO_RETURN_STATUS.equalsIgnoreCase(issuedBookRequest.getReturnStatus())
                && issuedBookRequest.getBook().getQuantity() > 1){
            issuedBookRequest.getBook().setIssued(issuedBookRequest.getBook().getIssued() + 1);
            issuedBookRequest.getBook().setQuantity(issuedBookRequest.getBook().getQuantity() - 1);
            issuedBookRequest.setReturnStatus(YES_RETURN_STATUS);
            entityManager.persist(issuedBookRequest);
            return BOOK_ISSUED_SUCCESSFULLY + issuedBookRequest.getStudent().getName();
        }else{
            return String.format(BOOK_NOT_ISSUED_FOR_REASONS
                    , issuedBookRequest.getBook().getCallno()
                    , issuedBookRequest.getReturnStatus()
                    , issuedBookRequest.getBook().getQuantity());
        }
    }
}
