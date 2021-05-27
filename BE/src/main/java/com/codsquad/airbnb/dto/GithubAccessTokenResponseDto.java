package com.codsquad.airbnb.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class GithubAccessTokenResponseDto {
    private String accessToken;
    private String tokenType;
    private String scope;

    public GithubAccessTokenResponseDto() {
    }

    public GithubAccessTokenResponseDto(String accessToken, String tokenType, String scope) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getScope() {
        return scope;
    }

    @JsonSetter("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonSetter("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonSetter("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "GithubAccessTokenResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
