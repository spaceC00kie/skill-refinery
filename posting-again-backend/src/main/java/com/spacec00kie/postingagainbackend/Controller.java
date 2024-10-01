package com.spacec00kie.postingagainbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    ArrayList<User> users = new ArrayList<>();

    @PostMapping("/create-user")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
        users.add(user);
        Map<String, String> map = new HashMap<>();
        map.put("yay", "All shiny, Cap'n");
        return ResponseEntity.ok(map);
    }
    @GetMapping("/get-users")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Map<String, String>> getUsers() {
        Map<String, String> map = Map.ofEntries(
                Map.entry("username", "Kaylee"),
                Map.entry("coatColor", "brown")
        );
        return ResponseEntity.ok(map);
    }
}
