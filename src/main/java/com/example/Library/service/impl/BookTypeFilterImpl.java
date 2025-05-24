package com.example.Library.service.impl;

import com.example.Library.enums.Operator;
import com.example.Library.model.Book;
import com.example.Library.service.BookFilterStrategy;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BookTypeFilterImpl implements BookFilterStrategy {
    @Override
    public List<Book> getFilteredBook(Operator operator, String value) {
        return List.of();
    }
}