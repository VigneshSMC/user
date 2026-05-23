package com.davincicell.user.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String email;
}
