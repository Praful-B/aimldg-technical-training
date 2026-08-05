package jar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jar.dto.numberDto;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class Assignment {
   
    @GetMapping("/fact")
    public ResponseEntity<Map<String, Integer>> getFactorial(@RequestParam("n") int n) {
        return ResponseEntity.ok(Map.of("n", calculateFactorial(n)));
    }

    private int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    @PostMapping("/sum/{n}")
    public ResponseEntity<numberDto> postNaturalNumberSum(@PathVariable int n) {
        return ResponseEntity.ok(new numberDto(n, n * (n + 1) / 2));
    }
    
}
