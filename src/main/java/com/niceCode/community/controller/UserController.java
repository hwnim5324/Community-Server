package com.niceCode.community.controller;

import com.niceCode.community.DAO.UsersDAO;
import com.niceCode.community.DTO.UsersDTO;
import com.niceCode.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(@RequestParam int userCode){
        List<UsersDTO> users = userService.findUsers(userCode);
        Map<String, Object> response = new HashMap<>();
        response.put("users", users);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
