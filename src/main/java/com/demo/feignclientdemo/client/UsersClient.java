package com.demo.feignclientdemo.client;

import com.demo.feignclientdemo.configuration.client.user.UsersClientConfiguration;
import com.demo.feignclientdemo.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(name = "users-service",url = "${client.url.jsonplaceholder}",configuration= UsersClientConfiguration.class)
public interface UsersClient {

    @GetMapping("/users")
    public Collection<UserDto> getUsers();
}
