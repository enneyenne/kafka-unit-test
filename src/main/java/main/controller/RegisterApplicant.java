package main.controller;

import main.kafkatests.KafkaMessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterApplicant {
    @Autowired
    KafkaMessageProducerService service;

    @GetMapping("/register")
    public ResponseEntity<String> register(@RequestBody String str){
        service.send("registrations",str);
        return ResponseEntity.ok("You registration has been acknowledged");
    }

    @GetMapping("/online")
    public ResponseEntity<String> watch(@RequestBody String str){
        service.send("online",str);
        return ResponseEntity.ok("thank you for subscribing");
    }
}
