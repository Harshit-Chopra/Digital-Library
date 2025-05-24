package com.example.Library.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class AuthorTest {
        // if i want to test that my getter is working fine, i will have to set the param first

        @Test
        public void testGetEmail(){
            // check something here , nothing to be returned
            Author author = new Author();
            author.setEmail("a@gmail.com");
            assertEquals("a@gmail.com",author.getEmail());
        }
    }
// any test
// check whether your test is passing or now
// assertion

// i set up everything whatever was required in order to test one functionaity
// check whatever i am expected, i am getting it

