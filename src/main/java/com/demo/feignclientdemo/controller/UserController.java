package com.demo.feignclientdemo.controller;

import com.demo.feignclientdemo.exception.BusinessException;
import com.demo.feignclientdemo.model.User;
import com.demo.feignclientdemo.service.UserService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController()
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    //@ExceptionHandler({ BusinessException.class })
    public ResponseEntity<List<User>> getUsers()  {

       List<User> Users =userService.getUsersData();

        return ResponseEntity.ok(Users);
    }

    @GetMapping("/error")
    public ResponseEntity<List<User>> getUsersThrowsException() throws SQLException {
        List<User> users = new ArrayList<>();
        if(CollectionUtils.isEmpty(users)) {
            throw new SQLException();
        }

        return ResponseEntity.ok(users);
    }
}
