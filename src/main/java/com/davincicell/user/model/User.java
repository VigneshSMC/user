package com.davincicell.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
}
