package com.example.Library.service.impl;

import com.example.Library.dto.UserRequest;
import com.example.Library.dto.UserResponse;
import com.example.Library.enums.Operator;
import com.example.Library.enums.UserFilter;
import com.example.Library.enums.UserType;
import com.example.Library.model.Book;
import com.example.Library.model.User;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.UserCacheRepository;
import com.example.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${student.authority}")
    private String studentAuthority;

    @Value("${admin.authority}")
    private String adminAuthority;

    @Autowired
    private UserCacheRepository userCacheRepository;

    public UserResponse createUser(UserRequest request) {
        User user = request.toUser();
        user.setType(UserType.STUDENT);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAuthorities(studentAuthority);
        User userFromDb = repository.save(user);
        return UserResponse.builder().
                userName(userFromDb.getName()).
                userAddress(userFromDb.getAddress()).
                userEmail(userFromDb.getEmail()).
                userPhone(userFromDb.getMobNo()).
                build();
    }

    public List<User> filter(UserFilter filterBy, Operator operator, String value) {
        switch (filterBy){
            case NAME :
                switch (operator){
                    case EQUALS :
                        return repository.findByName(value);

                    case LIKE:
                        return repository.findByNameContains(value);
                }
        }
        return new ArrayList<>();
    }

    public User checkIfUserIsValid(String userEmail) {
        return repository.findByEmail(userEmail);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userCacheRepository.getUser(email);
        if(user != null){
            return user;
        }
        user = repository.findByEmail(email);
        if(user == null)
            throw  new UsernameNotFoundException("No user found!!");
        userCacheRepository.setUser(email , user);
        return user;
    }

    public UserResponse addAdmin(UserRequest request) {
        User user = request.toUser();
        user.setType(UserType.ADMIN);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAuthorities(adminAuthority);
        User userFromDb = repository.save(user);
        return UserResponse.builder().
                userName(userFromDb.getName()).
                userAddress(userFromDb.getAddress()).
                userEmail(userFromDb.getEmail()).
                userPhone(userFromDb.getMobNo()).
                build();
    }

}


// some methods are actually there, u can directly call from ur service
// some methods not present in your jpa, then u are going to write queries ?

// u have to write the body completely for filter method of userservice ?

// book controller ?
// crud book book creation, book filteration

//@Cacheable :  cache in server : server/application
