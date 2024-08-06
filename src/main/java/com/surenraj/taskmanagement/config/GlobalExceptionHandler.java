package com.surenraj.taskmanagement.config;

import com.surenraj.taskmanagement.exception.ResourceCreationException;
import com.surenraj.taskmanagement.exception.ResourceDeleteException;
import com.surenraj.taskmanagement.exception.ResourceNotFoundException;
import com.surenraj.taskmanagement.exception.ResourceUpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//acts as central point for all kinds of exception
@RestControllerAdvice
public class GlobalExceptionHandler {
    //to handle not found cases
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  ResponseEntity<Map<String, String>>  handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        System.out.println("check error msg struc"+errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    //to handle creation exception
    @ExceptionHandler(ResourceCreationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleResourceCreationException(ResourceCreationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    //to handle update exception
    @ExceptionHandler(ResourceUpdateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleResourceUpdateException(ResourceUpdateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    //to handle delete exception
    @ExceptionHandler(ResourceDeleteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleResourceDeletionException(ResourceDeleteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    //to handle general server error cases
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
