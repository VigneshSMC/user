package com.davincicell.user.service;

import com.davincicell.user.exception.UserExistsException;
import com.davincicell.user.model.User;
import com.davincicell.user.request.LoginRequest;

public interface UserService {
    public void registerUser(User user) throws UserExistsException;
    public String verify(LoginRequest user);
}
