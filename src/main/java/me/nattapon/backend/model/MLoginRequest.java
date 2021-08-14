package me.nattapon.backend.model;

import lombok.Data;

@Data
public class MLoginRequest {
    private String password;
    private String email;
}
