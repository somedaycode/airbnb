package com.codsquad.airbnb.config;

import com.codsquad.airbnb.interceptor.OauthInterceptor;
import com.codsquad.airbnb.resolver.AuthenticatedUserResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final OauthInterceptor oauthInterceptor;
    private final AuthenticatedUserResolver authenticatedUserResolver;

    public WebConfig(OauthInterceptor oauthInterceptor,
                     AuthenticatedUserResolver authenticatedUserResolver) {
        this.oauthInterceptor = oauthInterceptor;
        this.authenticatedUserResolver = authenticatedUserResolver;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(oauthInterceptor)
                .addPathPatterns("/accomodation/reserve/{accomodationId}");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authenticatedUserResolver);
    }
}
