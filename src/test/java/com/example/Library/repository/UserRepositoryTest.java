package com.example.Library.repository;

import com.example.Library.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

    @DataJpaTest(properties = {
            "spring.datasource.url=jdbc:h2:mem:testdb",
            "spring.jpa.hibernate.ddl-auto=create-drop"
    })
    public class UserRepositoryTest {

        @Autowired
        private UserRepository userRepository;

        @BeforeEach
        public void setup(){
            User user1 = User.builder().name("mohit").email("mohit@gmail.com").build();
            userRepository.save(user1);

            User user2 = User.builder().name("mohit").email("mohit2@gmail.com").build();
            userRepository.save(user2);
        }
        @Test
        public void testFindByName(){
            List<User> users = userRepository.findByName("mohit");
            List<User> expectedList = new ArrayList<>();
            User u1 = User.builder().id(1).name("mohit").email("mohit@gmail.com").build();
            User u2 = User.builder().id(2).name("mohit").email("mohit@gmail.com").build();
            expectedList.add(u1);
            expectedList.add(u2);
            assertEquals(expectedList.size(), users.size());
        }
    }
