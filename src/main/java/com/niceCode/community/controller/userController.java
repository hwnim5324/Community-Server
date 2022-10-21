package com.niceCode.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @GetMapping("/users")
    public String getUsers(@RequestParam int userCode){
        return "hello";
    }
}
