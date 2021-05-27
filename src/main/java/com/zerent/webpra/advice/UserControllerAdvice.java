package com.zerent.webpra.advice;

import com.zerent.webpra.model.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResultVo bindException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        return new ResultVo(400, bindingResult.getFieldError().getDefaultMessage(), null);
    }
}
