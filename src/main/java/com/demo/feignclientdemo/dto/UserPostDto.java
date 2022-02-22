package com.demo.feignclientdemo.dto;

import lombok.Data;

@Data
public class UserPostDto {
    private  int id ;
    private String userId;
    private String title;
    private String body;
}
