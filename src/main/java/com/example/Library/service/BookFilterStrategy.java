package com.example.Library.service;


import com.example.Library.enums.Operator;
import com.example.Library.model.Book;
import java.util.List;

    public interface BookFilterStrategy {
        List<Book> getFilteredBook(Operator operator, String value);
    }
