package com.gc.firstappdemo.domain;

import java.util.List;

/**
 * @ClassName UserDto
 * @Description TODO
 * @Author guicheng
 * @Date 2018/12/17 13:57
 * @Version
 **/

public class UserDto  {
    private String userId;
    private String userName;
    private String userPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
