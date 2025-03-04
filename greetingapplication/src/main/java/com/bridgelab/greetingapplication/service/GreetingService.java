package com.bridgelab.greetingapplication.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World (GET)");
        return response;
    }

    public Map<String, String> postGreeting(String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + " POST request.");
        return response;
    }

    public Map<String, String> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World (PUT)");
        return response;
    }

    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World (DELETE)");
        return response;
    }
}
