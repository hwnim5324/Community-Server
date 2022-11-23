package com.niceCode.community.DTO;

import javax.persistence.*;

@Entity(name = "comments")
public class CommentsDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "commentCode")
    private int commentCode;
    @Column(name = "userName")
    private String userName;
    @Column(name = "postCode")
    private int postCode;
    @Column(name = "nestedWith")
    private int nested;
    @Column(name = "date")
    private String date;
    @Column(name = "content")
    private String content;

    public CommentsDTO(int commentCode, String userName, int postCode, int nested, String date, String content) {
        this.commentCode = commentCode;
        this.userName = userName;
        this.postCode = postCode;
        this.nested = nested;
        this.date = date;
        this.content = content;
    }

    public CommentsDTO(int commentCode, String userName, int postCode, String date, String content) {
        this.commentCode = commentCode;
        this.userName = userName;
        this.postCode = postCode;
        this.date = date;
        this.content = content;
    }

    public CommentsDTO(){ }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(int commentCode) {
        this.commentCode = commentCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public int getNested() {
        return nested;
    }

    public void setNested(int nested) {
        this.nested = nested;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
