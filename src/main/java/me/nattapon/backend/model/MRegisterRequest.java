package me.nattapon.backend.model;

import lombok.Data;

@Data
public class MRegisterRequest {
    private String password;
    private String name;
    private String email;
}
