package com.demo.feignclientdemo.utils;

import com.demo.feignclientdemo.exception.BusinessException;
import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        //todo check if status 200 will fo through this method
        FeignException exception = feign.FeignException.errorStatus(methodKey, response);
        switch (response.status()) {
            case 500:
               // return new BusinessException("custom msg");
                return new RetryableException(
                        response.status(),
                        exception.getMessage(),
                        response.request().httpMethod(),
                        exception,
                        null,
                        response.request());
            default:
                return exception;
        }
    }
}
