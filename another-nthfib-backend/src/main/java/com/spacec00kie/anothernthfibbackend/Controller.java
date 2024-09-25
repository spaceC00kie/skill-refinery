package com.spacec00kie.anothernthfibbackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {
    @GetMapping("/nthfib/{n}")
    public ResponseEntity<Map<String, Integer>> nthfib(@PathVariable int n) {
        Map<String, Integer> map = new HashMap<>();
        // if n is less than 3
        if (n < 3) {
            // return n - 1
            map.put("fib", n - 1);
            return ResponseEntity.ok(map);
        }
        // set count to 3
        int count = 2;
        // set previous array to [0, 1]
        int[] prev = {0, 1};
        // while count is less than n
        while (count < n) {
            // set prev0 to prev1 and set prev1 to prev0+prev1
            int temp = prev[0];
            prev[0] = prev[1];
            prev[1] = temp + prev[0];
            // increment count
            count++;
        }
        // return prev1
        map.put("fib", prev[1]);
        return ResponseEntity.ok(map);
    }
}
