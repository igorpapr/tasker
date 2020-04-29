package com.mycoursework.tasker.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class TestPrivateController {
    @GetMapping
    public String getMessage(){
        return "Hello from private controller";
    }
}
