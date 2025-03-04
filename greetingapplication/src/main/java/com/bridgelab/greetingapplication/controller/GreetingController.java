package com.bridgelab.greetingapplication.controller;

import com.bridgelab.greetingapplication.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting() {
        return greetingService.getGreeting();
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> requestBody) {
        String firstName = requestBody.getOrDefault("firstName", "");
        String lastName = requestBody.getOrDefault("lastName", "");
        return greetingService.generateGreeting(firstName, lastName);
    }
}
