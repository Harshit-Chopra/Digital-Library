package com.example.Library.service.impl;

import com.example.Library.model.Author;
import com.example.Library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorInDb(String authorEmail) {
        return authorRepository.findByEmail(authorEmail);
    }

    public Author saveMyAuthor(Author author) {
        return authorRepository.save(author);
    }
}