package com.example.Library.repository;

import com.example.Library.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

    @DataJpaTest(properties = {
            "spring.datasource.url=jdbc:h2:mem:testdb",
            "spring.jpa.hibernate.ddl-auto=create-drop"
    })
    public class AuthorRepositoryTest {

        @Autowired
        private AuthorRepository authorRepository;

        @BeforeEach
        public void setup(){
            Author a1 = Author.builder().email("a@gmail.com").name("a1").build();
            authorRepository.save(a1);
            Author a2 = Author.builder().email("b@gmail.com").name("a2").build();
            authorRepository.save(a2);
        }

        @Test
        public void testFindByEmail(){
            Author author = authorRepository.findByEmail("a@gmail.com");
            assertEquals(author.getName(), "a1");
        }

    }

// one database
// my test is going to be looking , return me the response
//unit : in memory db : h2
