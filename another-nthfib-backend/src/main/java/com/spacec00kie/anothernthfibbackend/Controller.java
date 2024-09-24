package com.spacec00kie.anothernthfibbackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {
    @GetMapping("/nthfib/{n}")
    public Number nthfib(@PathVariable Number n) {
        // Convert the Number to int
        int num = n.intValue();
        // if n is less than 3
        if (num < 3) {
            // return n - 1
            return num - 1;
        }
        // set count to 3
        int count = 2;
        // set previous array to [0, 1]
        int[] prev = {0, 1};
        // while count is less than n
        while (count < num) {
            // set prev0 to prev1 and set prev1 to prev0+prev1
            int temp = prev[0];
            prev[0] = prev[1];
            prev[1] = temp + prev[0];
            // increment count
            count++;
        }
        // return prev1
        return prev[1];
    }
}
