package com.bridgelab.greetingapplication.service;

import com.bridgelab.greetingapplication.model.Greeting;
import com.bridgelab.greetingapplication.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);  // Saves to MySQL
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();  // Retrieves all greetings
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
