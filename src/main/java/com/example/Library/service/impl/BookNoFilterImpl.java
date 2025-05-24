package com.example.Library.service.impl;

import com.example.Library.enums.Operator;
import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import com.example.Library.service.BookFilterStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookNoFilterImpl implements BookFilterStrategy {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getFilteredBook(Operator operator, String value) {
        if(!operator.equals(Operator.EQUALS)){
            throw  new IllegalArgumentException("Only Equals is expected with book no");
        }
        List<Book> books = bookRepository.findByBookNo(value);
        return books;
//        return books.
//                stream().
//                map(book -> convertToBookFilterResponse(book)).
//                collect(Collectors.toList());
    }
}