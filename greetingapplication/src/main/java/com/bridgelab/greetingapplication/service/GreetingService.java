package com.bridgelab.greetingapplication.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World");
        return response;
    }

    public Map<String, String> generateGreeting(String firstName, String lastName) {
        Map<String, String> response = new HashMap<>();

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            response.put("message", "Hello, " + firstName + " " + lastName + "!");
        } else if (firstName != null && !firstName.isEmpty()) {
            response.put("message", "Hello, " + firstName + "!");
        } else if (lastName != null && !lastName.isEmpty()) {
            response.put("message", "Hello, " + lastName + "!");
        } else {
            response.put("message", "Hello, World");
        }

        return response;
    }
}
