package com.surenraj.taskmanagement.exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        //calling
        super(message);
    }
}
