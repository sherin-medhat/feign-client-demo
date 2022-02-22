package com.demo.feignclientdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    private  int id ;
    @JsonProperty("name")
    private String name;
    @JsonProperty("userName")
    private String UserName;
    @JsonProperty("email")
    private String email;


}
