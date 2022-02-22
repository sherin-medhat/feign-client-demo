package com.demo.feignclientdemo.service.impl;

import com.demo.feignclientdemo.client.MockExceptionClient;
import com.demo.feignclientdemo.client.PostsClient;
import com.demo.feignclientdemo.client.UsersClient;
import com.demo.feignclientdemo.dto.UserDto;
import com.demo.feignclientdemo.dto.UserPostDto;
import com.demo.feignclientdemo.exception.BusinessException;
import com.demo.feignclientdemo.model.User;
import com.demo.feignclientdemo.service.UserService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PostsClient postsClient;
    @Autowired
    private UsersClient usersClient;
    @Autowired
    private MockExceptionClient mockExceptionClient;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getUsersData() {
        List<User> users= new ArrayList<>();
       // Collection<EmployeeDto> employeesDto  = employeeClient.getEmployees();
        Collection<UserDto> usersDto  = usersClient.getUsers();
        UserPostDto userPost =postsClient.getUserPost("1");
        postsClient.getUserPostNotFound("1");
        try
        {
            mockExceptionClient.getError();
        }catch (BusinessException ex){
        }

      if(!CollectionUtils.isEmpty(usersDto)){
          users = usersDto.stream().map(this::convertUserDtoToUser).collect(Collectors.toList());
      }
      return  users;
    }


    private  User convertUserDtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
