package com.niceCode.community.mapper;

import com.niceCode.community.DTO.UsersDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDTOMapper implements RowMapper<UsersDTO> {
    @Override
    public UsersDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsersDTO user = new UsersDTO(
                rs.getInt("userCode"),
                rs.getString("userName"),
                rs.getInt("userBirth"),
                rs.getString("userGender"),
                rs.getString("userEmail"),
                rs.getString("userId"),
                rs.getString("userPw"));
        return user;
    }
}