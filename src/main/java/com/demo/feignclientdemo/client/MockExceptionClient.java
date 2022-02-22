package com.demo.feignclientdemo.client;

import com.demo.feignclientdemo.dto.UserPostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mock-exception-service",url = "${client.url.exceptionThrower}")
public interface MockExceptionClient {

    @GetMapping("")
    UserPostDto getError();
}
