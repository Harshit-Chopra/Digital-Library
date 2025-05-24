package com.example.Library.repository;

import com.example.Library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    // search via name
    // search like name

    // repo
    // 3 ways to write the queries

//    1)  way by which u can write the method name and it is going to return u the response
    // no query at all, we are going to use the most

    List<User> findByName(String name);
    List<User> findByNameContains(String name);

    //    2 way of writing the queries
    @Query(value = "select u from User u where name=:name", nativeQuery = false)
    List<User> retreiveUserViaName(String name);

    // 3 ways
    @Query(value = "select * from user where name=:name", nativeQuery = true)
    List<User> retreiveUserViaNameNative(String name);

    User findByEmail(String  email);
}
