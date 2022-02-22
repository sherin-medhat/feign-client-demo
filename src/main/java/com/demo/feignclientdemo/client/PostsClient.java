package com.demo.feignclientdemo.client;

import com.demo.feignclientdemo.dto.UserPostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.Optional;

@FeignClient(name = "post-service",url = "${client.url.jsonplaceholder}", decode404 = true)
public interface PostsClient {

    @GetMapping("/posts/{postId}")
    UserPostDto getUserPost(@PathVariable String postId);

    @GetMapping("/posts/notExists/{postId}")
    Optional<UserPostDto> getUserPostNotFound(@PathVariable String postId);
}
