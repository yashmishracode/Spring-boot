package com.yash.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    //exception handler code here
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFound exc){

        //Create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return Responsibility

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Another exception handler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        //Create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return Responsibility

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
