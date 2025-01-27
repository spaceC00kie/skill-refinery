package com.spacec00kie.justabackend;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/backend")
public class Controller {

    String name = "nothing yet";

    @GetMapping("/get")
    public String get() {
        return "Hello " + name;
    }

//    should be json
    @PostMapping("/post")
    public String post(@RequestBody Message message) {
        return "Your name is now " + message.body;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody String body) {
        return "You deleted it, all right";
    }
}
