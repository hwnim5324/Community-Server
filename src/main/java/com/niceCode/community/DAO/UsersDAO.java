package com.niceCode.community.DAO;

import com.niceCode.community.DTO.UsersDTO;
import com.niceCode.community.mapper.UsersDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersDAO {

    private final JdbcTemplate jdbcTemplate;

    public UsersDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UsersDTO> findByUserCode(int userCode){
        String SQL = "SELECT * FROM users";
        return jdbcTemplate.query(SQL, usersRowMapper());
    }

    private RowMapper<UsersDTO> usersRowMapper() {
        return new RowMapper<UsersDTO>() {
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
        };
    }
}

