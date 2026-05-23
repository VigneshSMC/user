package com.davincicell.user.service.impl;

import com.davincicell.user.entity.UserData;
import com.davincicell.user.exception.UserExistsException;
import com.davincicell.user.model.User;
import com.davincicell.user.repo.UserRepo;
import com.davincicell.user.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo repo;
    private PasswordEncoder encoder;
    private AuthenticationManager manager;
    private JwtService jwt;

    UserServiceImpl(UserRepo repo, PasswordEncoder encoder, AuthenticationManager manager, JwtService service) {
        this.repo = repo;
        this.encoder = encoder;
        this.manager = manager;
        jwt = service;
    }

    @Override
    public void registerUser(User user) throws UserExistsException {
        Optional.ofNullable(repo.findByEmail(user.getEmail())).ifPresent(userDat -> {throw new UserExistsException(userDat.getEmail());});
        UserData mapUser = new UserData();
        mapUser.setUsername(user.getUsername());
        mapUser.setEmail(user.getEmail());
        mapUser.setPassword(encoder.encode(user.getPassword()));
        repo.save(mapUser);
    }

    @Override
    public String verify(User user) {
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwt.buildToken(user);
        }
        else return "Fail";
    }
}
