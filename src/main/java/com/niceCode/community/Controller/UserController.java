package com.niceCode.community.Controller;

import com.niceCode.community.DTO.UsersDTO;
import com.niceCode.community.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")       //create
    public ResponseEntity<UsersDTO> signUp(@RequestBody UsersDTO user){
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PostMapping("/signin")       //read
    public Integer signIn(@RequestBody UsersDTO user){
        UsersDTO userFinded = userService.readByUserId(user.getUserId()).get();
        String PW = userFinded.getUserPw();
        if(user.getUserPw().equals(PW)){
            return userFinded.getUserCode();
        }
        return -1;
    }

    @GetMapping("/users/{userCode}")       //read
    public ResponseEntity<UsersDTO> getUser(@PathVariable(value="userCode") int userCode){
        return ResponseEntity.ok().body(userService.readByUserCode(userCode).get());
    }

    @PatchMapping("/users")     //update
    public ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO user){
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @DeleteMapping("/users/{userCode}")     //delete
    public boolean deleteUser(@PathVariable(value="userCode") int userCode){
        return userService.deleteUser(userCode);
    }

}
