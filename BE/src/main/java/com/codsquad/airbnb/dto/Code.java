package com.codsquad.airbnb.dto;

import java.beans.ConstructorProperties;

public class Code {
    private String code;

    @ConstructorProperties("code")
    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                '}';
    }
}
