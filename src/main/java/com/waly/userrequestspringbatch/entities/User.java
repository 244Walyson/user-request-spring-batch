package com.waly.userrequestspringbatch.entities;

import com.waly.userrequestspringbatch.dto.UserDTO;

public class User extends UserDTO {

    private String login;
    private String avatarUrl;
    private String name;

    public User(){
        super();
    }

    public User(String login, String avatarUrl) {
        super();
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
