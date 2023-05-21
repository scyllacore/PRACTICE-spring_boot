package com.scyllacore.jblogweb.advice;

import com.scyllacore.jblogweb.dto.ResponseDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class ValidationCheckAdvice {
    @Around("execution(* com.scyllacore..controller.*Controller.*(..))")
    public Object validationCheck(ProceedingJoinPoint jp) throws Throwable{
        Object[] args = jp.getArgs();

        for(Object arg : args){

            if(arg instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) arg;
                if(bindingResult.hasErrors()){
                    Map<String,String> errorMap = new HashMap<>();
                    for(FieldError fieldError : bindingResult.getFieldErrors()){
                        errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    }
                    return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), errorMap);
                }
            }
        }

        return jp.proceed();
    }
}
