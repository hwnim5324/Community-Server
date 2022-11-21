package com.niceCode.community.Service;

import com.niceCode.community.DTO.UsersDTO;
import com.niceCode.community.Repository.JPAUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private JPAUsersRepository jpaUsersRepository;

    @Autowired
    public UserService(JPAUsersRepository jpaUsersRepository){
        this.jpaUsersRepository = jpaUsersRepository;
    }

    public UsersDTO createUser(UsersDTO user){
        return jpaUsersRepository.save(user);
    }

    public Optional<UsersDTO> readByUserCode(int userCode){
        return jpaUsersRepository.findById(userCode);
    }

    public Optional<UsersDTO> readByUserId(String userId) {
        return jpaUsersRepository.findByUserId(userId);
    }

    public UsersDTO updateUser(UsersDTO user){
        //userCode가 존재하는지 판별 후 업데이트로 변경 필요.
        return jpaUsersRepository.save(user);
    }

    public boolean deleteUser(int userCode){
        //userCode가 존재하는지 판별 후 제거로 변경 및 true,false 반환 필요.
        jpaUsersRepository.deleteById(userCode);
        return true;
    }
}
