package com.niceCode.community.Controller;

import com.niceCode.community.DTO.CommentsDTO;
import com.niceCode.community.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private  final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentsDTO> newComment(@RequestBody CommentsDTO comment){
        return ResponseEntity.ok().body(commentService.newComment(comment));
    }

    @GetMapping("/comments/{postCode}")
    public ResponseEntity<List<CommentsDTO>> getComments(@PathVariable(value="postCode")int postCode){
        return ResponseEntity.ok().body(commentService.getComments(postCode));
    }

    @PatchMapping("/comments")
    public ResponseEntity<CommentsDTO> updateComment(@RequestBody CommentsDTO comment){
        return ResponseEntity.ok().body(commentService.updateComment(comment));
    }

    @DeleteMapping("/comments/{commentCode}")
    public Boolean deleteComment(@PathVariable(value="commentCode")int commentCode){
        return commentService.deleteComment(commentCode);
    }
}
