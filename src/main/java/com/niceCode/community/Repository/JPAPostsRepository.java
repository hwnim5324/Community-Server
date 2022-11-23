package com.niceCode.community.Repository;

import com.niceCode.community.DTO.PostsDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JPAPostsRepository extends JpaRepository<PostsDTO, Integer> {
    List<PostsDTO> findAllByUserCodeOrderByDate(Integer userCode);

    @Override
    Optional<PostsDTO> findById(Integer postCode);

    @Override
    List<PostsDTO> findAll(Sort sort);

    @Override
    PostsDTO save(PostsDTO post);

    @Override
    void deleteById(Integer postCode);
}
