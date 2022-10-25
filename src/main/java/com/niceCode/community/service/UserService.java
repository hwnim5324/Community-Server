package com.niceCode.community.service;

import com.niceCode.community.DAO.UsersDAO;
import com.niceCode.community.DTO.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    private final UsersDAO usersDAO;

    @Autowired
    public UserService(UsersDAO usersDAO){
        this.usersDAO = usersDAO;
    }

    public List<UsersDTO> findUsers(int userCode){
        return usersDAO.findByUserCode(userCode);
    }
}
