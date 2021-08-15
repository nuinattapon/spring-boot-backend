package me.nattapon.backend.api;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloApi {
    @GetMapping
    public ResponseEntity<String> hello(@RequestParam(name = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello, " + name + "!");
    }
}