package com.demo.feignclientdemo.configuration.client.user;

import com.demo.feignclientdemo.utils.CustomErrorDecoder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;


public class UsersClientConfiguration {
    @Bean
    public Logger.Level configureLogLevel(){
        return  Logger.Level.FULL;
    }
}
