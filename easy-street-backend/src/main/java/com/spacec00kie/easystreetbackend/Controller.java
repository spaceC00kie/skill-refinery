package com.spacec00kie.easystreetbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/get-user")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Map<String, String>> getUser() {
        Map<String, String> map = Map.ofEntries(
                Map.entry("username", "Dr. Mrs. The Monarch")
        );
        return ResponseEntity.ok(map);
    }
}
