package com.ohgiraffers.section04.onetoone.subsection01;

import javax.persistence.*;

@Entity(name ="user1")
@Table(name = "tbl_user1")
public class User {
    //계정에 대한 테이블
    @Id
    private  Long userCode;
    private String userId;
    private String userPwd;
    //FK를 User가 가지는 경우 매핑할떄
    @OneToOne
    @JoinColumn(name= "userInfoCode")//카멜케이스로 변환하서 매핑되도록 작성해줌
    private UserInfo userInfo;

    public User() {
    }

    public User(Long userCode, String userId, String userPwd, UserInfo userInfo) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userInfo = userInfo;
    }

    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userCode=" + userCode +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
