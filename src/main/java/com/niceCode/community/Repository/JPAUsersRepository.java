package com.niceCode.community.Repository;

import com.niceCode.community.DTO.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAUsersRepository extends JpaRepository<UsersDTO, Integer> {
    @Override
    Optional<UsersDTO> findById(Integer userCode);

    @Override
    UsersDTO save(UsersDTO user);

    @Override
    void deleteById(Integer userCode);
}
