package com.niceCode.community.DTO;

public class UsersDTO {
    private int userCode;
    private String userName;
    private int userBirth;
    private String userGender;
    private String userEmail;
    private String userId;
    private String userPw;

    public UsersDTO(int userCode, String userName, int userBirth, String userGender, String userEmail, String userId, String userPw) {
        this.userCode = userCode;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userId = userId;
        this.userPw = userPw;
    }

    public UsersDTO() {
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(int userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
}
