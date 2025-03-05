package com.bridgelab.greetingapplication.controller;

import com.bridgelab.greetingapplication.model.Greeting;
import com.bridgelab.greetingapplication.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    public Greeting saveGreeting(@RequestBody Map<String, String> requestBody) {
        String message = requestBody.getOrDefault("message", "Hello, World");
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingService.getGreetingById(id);

        if (greeting.isPresent()) {
            return ResponseEntity.ok(greeting.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Greeting Not Found with ID: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String newMessage = requestBody.get("message"); // Extract new message from request body

        Optional<Greeting> updatedGreeting = greetingService.updateGreeting(id, newMessage);

        if (updatedGreeting.isPresent()) {
            return ResponseEntity.ok(updatedGreeting.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Greeting Not Found with ID: " + id);
        }
    }

}
