package com.mycoursework.tasker.web.сontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class TestController {
    @GetMapping
    public String getMessage(){
        return "Hello from public controller";
    }
}
