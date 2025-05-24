package com.example.Library.controller;

import com.example.Library.dto.UserRequest;
import com.example.Library.dto.UserResponse;
import com.example.Library.enums.Operator;
import com.example.Library.enums.UserFilter;
import com.example.Library.model.User;
import com.example.Library.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/createStudent")
    public UserResponse createUser(@RequestBody @Validated UserRequest user) {

        return service.createUser(user);
    }

    @PostMapping("/addAdmin")
    public UserResponse addAdmin(@RequestBody @Validated UserRequest request){
        return service.addAdmin(request);
    }

    @GetMapping("/filter")
    public List<User> filteredUser(@RequestParam("filterBy") UserFilter filterBy,
                                   @RequestParam("operator") Operator operator,
                                   @RequestParam("value") String value
    ) {
        return service.filter(filterBy, operator, value);
    }

}
