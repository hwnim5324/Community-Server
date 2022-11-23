package com.niceCode.community.Service;

import com.niceCode.community.DTO.CommentsDTO;
import com.niceCode.community.Repository.JPACommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private JPACommentsRepository jpaCommentsRepository;

    @Autowired
    public CommentService(JPACommentsRepository jpaCommentsRepository){
        this.jpaCommentsRepository = jpaCommentsRepository;
    }

    public CommentsDTO newComment(CommentsDTO comment){
        LocalDateTime now = LocalDateTime.now();
        comment.setDate(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return jpaCommentsRepository.save(comment);
    }

    public Optional<CommentsDTO> getComment(int commentCode){
        return jpaCommentsRepository.findById(commentCode);
    }

    public List<CommentsDTO> getComments(int postCode){
        return jpaCommentsRepository.findAllByPostCodeOrderByDate(postCode);
    }

    public CommentsDTO updateComment(CommentsDTO comment){
        CommentsDTO update = getComment(comment.getCommentCode()).get();
        update.setContent(comment.getContent());
        return jpaCommentsRepository.save(update);
    }

    public boolean deleteComment(int commentCode){
        try{
            jpaCommentsRepository.deleteById(commentCode);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
