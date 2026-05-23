package com.davincicell.user.exception;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String username) {
        super("email - " + username + " already exists");
    }
}
