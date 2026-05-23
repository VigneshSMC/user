package com.davincicell.user.exception;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String username) {
        super("Username - " + username + " already exists");
    }
}
