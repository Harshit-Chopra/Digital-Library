package com.example.Library.service.impl;

import com.example.Library.dto.BookRequest;
import com.example.Library.dto.BookResponse;
import com.example.Library.enums.BookFilter;
import com.example.Library.enums.Operator;
import com.example.Library.model.Author;
import com.example.Library.model.Book;
import com.example.Library.model.User;
import com.example.Library.repository.BookRepository;
import com.example.Library.service.BookFilterStrategy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookFilterFactory bookFilterFactory;

    public BookResponse createBook(BookRequest request) {
        // author is already present or not?
        Author authorFromDb = authorService.findAuthorInDb(request.getAuthorEmail());
        Book book = request.toBook();
        if(authorFromDb == null){
            authorFromDb = Author.builder().
                    email(request.getAuthorEmail()).
                    name(request.getAuthorName()).
                    build();
        }
        book.setAuthor(authorFromDb);
        Book bookFromDb = repository.save(book);
        return BookResponse.builder().
                bookNo(bookFromDb.getBookNo()).
                bookName(bookFromDb.getTitle()).
                securityAmount(bookFromDb.getSecurityAmount()).
                build();

    }

    public List<Book> filter(BookFilter filterBy, @NotNull(message = "operator must not be null") Operator operator, @NotBlank(message = "value must not be blank") String value) {
        // cases here , switch , if else
        BookFilterStrategy stratergy = bookFilterFactory.getStratergy(filterBy);
        return stratergy.getFilteredBook(operator, value);
    }

    public Book checkIfBookIsValid(String bookNo) {
        List<Book> books= repository.findByBookNo(bookNo);
        if(books.isEmpty()){
            return null;
        }
        return books.get(0);
    }

    public void markBookUnavailable(Book bookFromDb, User userFromDb) {
        bookFromDb.setUser(userFromDb);
        repository.save(bookFromDb);
    }
}
