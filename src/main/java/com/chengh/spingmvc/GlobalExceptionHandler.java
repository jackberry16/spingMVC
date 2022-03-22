package com.chengh.spingmvc;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        return Result.of(ResultCode.UNKNOWN_ERROR);
    }

    /**
     * 捕获自定义异常
     *
     * @param e 异常
     */
    @ExceptionHandler(TestException.class)
    public Result handlerMyException(TestException e) {
        return Result.of(e.getResultCode());
    }

}
