package com.maisen.issue_tracker.common;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 拦截我们自定义的业务异常
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException e) {
        return Result.error(e.getMessage());
    }

    // 拦截所有其他未知异常（防止把一堆杂乱的红字抛给前端）
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        e.printStackTrace(); // 控制台还是打印一下，方便你排错
        return Result.error("系统内部错误，请联系管理员");
    }
}