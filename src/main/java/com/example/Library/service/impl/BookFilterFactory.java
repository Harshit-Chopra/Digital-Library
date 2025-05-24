package com.example.Library.service.impl;

import com.example.Library.enums.BookFilter;
import com.example.Library.service.BookFilterStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

    @Component
    public class BookFilterFactory {

        private final Map<BookFilter, BookFilterStrategy> stratergies = new HashMap<>();

        public BookFilterFactory(BookNoFilterImpl bookNoFilter, BookTitleFilterImpl bookTitleFilter, BookTypeFilterImpl bookTypeFilter){
            stratergies.put(BookFilter.BOOK_NO, bookNoFilter);
            stratergies.put(BookFilter.BOOK_TYPE, bookTypeFilter);
            stratergies.put(BookFilter.BOOK_TITLE, bookTitleFilter);
        }
        public BookFilterStrategy getStratergy(BookFilter filter){
            return stratergies.get(filter);
        }

    }
