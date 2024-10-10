package main.controller;

import main.kafkatests.GetWatchersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetWatchers {
    @Autowired
    GetWatchersService service;

    @GetMapping("/getAllWatches")
    List<String> getAll(){
        return service.getAll();
    }
}
