package com.niceCode.community.Repository;

import com.niceCode.community.DTO.CommentsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JPACommentsRepository extends JpaRepository<CommentsDTO, Integer> {
    @Override
    CommentsDTO save(CommentsDTO comment);

    List<CommentsDTO> findAllByPostCodeOrderByDate(Integer postCode);

    @Override
    Optional<CommentsDTO> findById(Integer commentCode);

    @Override
    void deleteById(Integer integer);
}
