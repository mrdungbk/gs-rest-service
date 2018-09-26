package com.management.devices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvide {

//    @ResponseBody
//    @ExceptionHandler(EmployeeNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    String notFoundHandler(EmployeeNotFoundException ex) {
//        return ex.getMessage();
//    }
}