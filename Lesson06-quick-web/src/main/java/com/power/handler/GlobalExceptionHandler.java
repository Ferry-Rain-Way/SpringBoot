package com.power.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义全局异常处理
 * `@ControllerAdvice` ,@RestControllerAdvice 一起完成异常的处理。
 * `@ControllerAdvice` 与@RestControllerAdvice 区别在于：
 * `@RestControllerAdvice 加了@RepsonseBody。
 * 自定义方法同@Controller中方法的定义
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 相当于catch,匹配具体是哪一种异常
     * @param e 具体异常
     * @return 返回错误数据
     */
    @ExceptionHandler({ArithmeticException.class})
    public String handlerArtithmeticException(ArithmeticException e) {
        // 也可以使用@ControllAdvice 返回视图
        return "这是一个算数异常" + e.getMessage();
    }

    /**
     * 校验异常统一处理 校验参数异常
     * @param e
     * @return
     */
    @ExceptionHandler({BindException.class})
    public Map<String, Object> handleJSR303Exception(BindException e) {
        Map<String, Object> map = new HashMap<>();
        /* 此处注意BindException存在同名类,要导入
        import org.springframework.validation.BindException;*/
        BindingResult result = e.getBindingResult();

        //输出 : 错误的属性和错误的信息数组
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            errors.forEach(field -> {
                map.put("错误[" + field.getField() + "]原因", field.getDefaultMessage());
            });
        }
        return map;
    }


    /**
     * 处理图书未找到异常
     * 使用 ProblemDetail
     * @param e
     * @return
     */
    @ExceptionHandler({BookNotFoundException.class})
    public ProblemDetail handleBookNotFoundException(BookNotFoundException e ){
        //HttpStatus.NOT_FOUND → 404
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        //如果需要查看更加详细的异常信息,可以再写一个服务,用于描述异常信息
        problemDetail.setType(URI.create("/probs/not-found"));
        problemDetail.setTitle("图书查找异常");

        //增加自定义信息
        //时间戳
        // "timestamp": "2023-04-26T12:55:53.632403Z",
        problemDetail.setProperty("timestamp", Instant.now());
            //客服信息
        problemDetail.setProperty("客服邮箱","service@hello.com");

        return problemDetail;
    }

/*    @ExceptionHandler({BookNotFoundException.class})
    public ErrorResponse bookNotFoundExceptionReturnErrorResponse(BookNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.NOT_FOUND,e);
        return  errorResponse;
    }*/
}
