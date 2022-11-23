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
        UsersDTO update = readByUserCode(user.getUserCode()).get();
        update.setUserId(user.getUserId());
        update.setUserPw(user.getUserPw());
        update.setUserName(user.getUserName());
        update.setUserBirth(user.getUserBirth());
        update.setUserEmail(user.getUserEmail());
        return jpaUsersRepository.save(update);
    }

    public boolean deleteUser(int userCode){
        try{
            jpaUsersRepository.deleteById(userCode);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
