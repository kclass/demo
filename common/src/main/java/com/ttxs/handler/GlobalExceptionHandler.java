package com.ttxs.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author kai.hu
 * @date 2020/3/26 16:53
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
