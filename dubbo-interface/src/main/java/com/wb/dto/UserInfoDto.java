package com.wb.dto;

import java.io.Serializable;

public class UserInfoDto implements Serializable {

    private Integer userId;
    private String username;

    public UserInfoDto() {
    }

    public UserInfoDto(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
