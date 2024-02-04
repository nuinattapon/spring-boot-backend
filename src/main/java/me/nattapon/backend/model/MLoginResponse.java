package me.nattapon.backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MLoginResponse {
    private String email;
    private String name;
}
