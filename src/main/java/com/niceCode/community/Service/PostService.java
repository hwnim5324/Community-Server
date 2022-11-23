package com.niceCode.community.Service;

import com.niceCode.community.DTO.PostsDTO;
import com.niceCode.community.Repository.JPAPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private JPAPostsRepository jpaPostsRepository;

    @Autowired
    public PostService(JPAPostsRepository jpaPostsRepository){
        this.jpaPostsRepository = jpaPostsRepository;
    }

    public PostsDTO createPost(PostsDTO post){
        LocalDateTime now = LocalDateTime.now();
        post.setDate(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return jpaPostsRepository.save(post);
    }
    public PostsDTO updatePost(PostsDTO post){
        PostsDTO update = getPost(post.getPostCode()).get();
        update.setContent(post.getContent());
        update.setTitle(post.getTitle());
        return jpaPostsRepository.save(update);
    }

    public Optional<PostsDTO> getPost(int postCode){
        return jpaPostsRepository.findById(postCode);
    }

    public List<PostsDTO> getPosts(){
        return jpaPostsRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public List<PostsDTO> getPostsByUser(int userCode){
        return jpaPostsRepository.findAllByUserCodeOrderByDate(userCode);
    }

    public boolean deletePost(int postCode){
        try{
            jpaPostsRepository.deleteById(postCode);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
