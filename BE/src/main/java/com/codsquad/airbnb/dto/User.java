package com.codsquad.airbnb.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String login;
    private String name;

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }
}
