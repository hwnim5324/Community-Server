package com.niceCode.community.DAO;

import com.niceCode.community.DTO.UsersDTO;
import com.niceCode.community.mapper.UsersDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UsersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UsersDTO> findByUserCode(int userCode){
        RowMapper<UsersDTO> mapper = new UsersDTOMapper();
        String query = "SELECT * FROM users WHERE userCode = ?";

        return jdbcTemplate.query(query, mapper, userCode);
    }
}

