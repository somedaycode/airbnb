package com.codsquad.airbnb.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class User {
    private String login;
    private String name;

    public User() {
    }

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    @JsonSetter("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }
}
