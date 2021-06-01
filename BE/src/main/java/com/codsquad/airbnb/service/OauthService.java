package com.codsquad.airbnb.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.codsquad.airbnb.dto.GithubAccessTokenRequestDto;
import com.codsquad.airbnb.dto.GithubAccessTokenResponseDto;
import com.codsquad.airbnb.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OauthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OauthService.class);

    private final String CLIENT_ID;
    private final String CLIENT_SECRET;

    public OauthService(Environment environment) {
        CLIENT_ID = environment.getProperty("github.client.id");
        CLIENT_SECRET = environment.getProperty("github.client.secret");
    }

    public Optional<User> getUserFromGitHub(GithubAccessTokenResponseDto accessToken) {
        String githubUserUri = "https://api.github.com/user";

        LOGGER.debug("accessToken : {}", accessToken.getAccessToken());

        RequestEntity<Void> request = RequestEntity
                .get(githubUserUri)
                .header("Accept", "application/json")
                .header("Authorization", "token " + accessToken.getAccessToken())
                .build();

        ResponseEntity<User> response = new RestTemplate()
                .exchange(request, User.class);

        return Optional.ofNullable(response.getBody());
    }

    public Optional<GithubAccessTokenResponseDto> getAccessToken(String code) {
        String githubAccessTokenUri = "https://github.com/login/oauth/access_token";

        RequestEntity<GithubAccessTokenRequestDto> request = RequestEntity
                .post(githubAccessTokenUri)
                .header("Accept", "application/json")
                .body(new GithubAccessTokenRequestDto(CLIENT_ID, CLIENT_SECRET, code));

        LOGGER.debug("request : {}", request);

        ResponseEntity<GithubAccessTokenResponseDto> response = new RestTemplate()
                .exchange(request, GithubAccessTokenResponseDto.class);

        LOGGER.debug("response : {}", response);

        return Optional.ofNullable(response.getBody());
    }

    public String getJwt(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");

            return JWT.create()
                    .withClaim("login", user.getLogin())
                    .withClaim("name", user.getName())
                    .withIssuer("jwtTest")
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException(exception);
        }
    }
}
