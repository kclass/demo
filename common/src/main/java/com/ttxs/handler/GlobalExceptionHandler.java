package com.ttxs.handler;

import com.ttxs.exception.UnsatisfactoryException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author kai.hu
 * @date 2020/3/26 16:53
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     * @param e 异常
     * @return 提示信息
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return "请求失败了";
    }

    @ExceptionHandler(UnsatisfactoryException.class)
    public String unsatisfactoryExceptionHandler(UnsatisfactoryException e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
