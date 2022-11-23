package com.niceCode.community.DTO;

import javax.persistence.*;

@Entity(name = "posts")
public class PostsDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "postCode")
    private int postCode;
    @Column(name = "userCode")
    private int userCode;
    @Column(name = "userName")
    private String userName;
    @Column(name = "date")
    private String date;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public PostsDTO(int postCode, int userCode, String userName, String date, String title, String content) {
        this.postCode = postCode;
        this.userCode = userCode;
        this.userName = userName;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public PostsDTO(){ }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
