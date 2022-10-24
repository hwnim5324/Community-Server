package com.niceCode.community.controller;

import com.niceCode.community.DAO.UsersDAO;
import com.niceCode.community.DTO.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {

    @GetMapping("/users")
    public List<UsersDTO> getUsers(@RequestParam int userCode) throws Exception{
        UsersDAO users = new UsersDAO();    //생성자에서 해줄지 고민.
        return users.findByUserCode(userCode);
    }
}
