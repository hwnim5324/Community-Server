package com.niceCode.community.Controller;

import com.niceCode.community.DTO.PostsDTO;
import com.niceCode.community.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/posts")   //create
    public ResponseEntity<PostsDTO> newPost(@RequestBody PostsDTO post){
        return ResponseEntity.ok().body(postService.createPost(post));
    }

    @GetMapping("/posts")    //read
    public ResponseEntity<List<PostsDTO>> getPosts(){
        return ResponseEntity.ok().body(postService.getPosts());
    }

    @GetMapping("/posts/{postCode}")    //read
    public ResponseEntity<PostsDTO> getPost(@PathVariable(value="postCode")int postCode){
        return ResponseEntity.ok().body(postService.getPost(postCode).get());
    }

    @GetMapping("/posts/user/{userCode}")   //read by user
    public ResponseEntity<List<PostsDTO>> getPostsByUser(@PathVariable(value="userCode")int userCode){
        return ResponseEntity.ok().body(postService.getPostsByUser(userCode));
    }

    @PatchMapping("/posts") //update
    public ResponseEntity<PostsDTO> updatePost(@RequestBody PostsDTO post){
        return ResponseEntity.ok().body(postService.updatePost(post));
    }

    @DeleteMapping("/posts/{postCode}") //delete
    public boolean deletePost(@PathVariable(value="postCode")int postCode){
        return postService.deletePost(postCode);
    }
}
