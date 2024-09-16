package com.spacec00kie.noplanbackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {
    @GetMapping("/sup")
    public String greeting() {
        return "Hi";
    }
}
