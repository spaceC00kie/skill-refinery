package com.spacec00kie.postingbackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @PostMapping("/posting")
    @CrossOrigin(origins = "http://localhost:5173")
    public void createUser(@RequestBody User user) {

    }
}
