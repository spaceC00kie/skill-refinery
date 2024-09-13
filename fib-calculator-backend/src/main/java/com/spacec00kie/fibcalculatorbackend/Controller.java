package com.spacec00kie.fibcalculatorbackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
