package com.demo.feignclientdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private  int id ;
    private String name;
    private String UserName;
    private String email;


}
