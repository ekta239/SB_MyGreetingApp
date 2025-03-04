package com.bridgelab.greetingapplication.controller;

import com.bridgelab.greetingapplication.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection of Service Layer
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting() {
        return greetingService.getGreeting();
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> requestBody) {
        return greetingService.postGreeting(requestBody.get("name"));
    }

    @PutMapping
    public Map<String, String> putGreeting() {
        return greetingService.putGreeting();
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return greetingService.deleteGreeting();
    }
}
