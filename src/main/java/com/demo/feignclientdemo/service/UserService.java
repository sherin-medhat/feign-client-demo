package com.demo.feignclientdemo.service;

import com.demo.feignclientdemo.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

   List<User> getUsersData();
}
