package com.learing.Spring_jwt_jpa.controller;

import com.learing.Spring_jwt_jpa.dto.CreateUserDto;
import com.learing.Spring_jwt_jpa.entity.User;
import com.learing.Spring_jwt_jpa.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@Validated @RequestBody CreateUserDto createUserDto){
        log.info("Creating user..");
        User response = service.createUser(createUserDto);
        return new ResponseEntity<User>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity getUser(String userName){

        User response = service.getUser(userName);
        return new ResponseEntity<User>(response, HttpStatus.OK);
    }
}
