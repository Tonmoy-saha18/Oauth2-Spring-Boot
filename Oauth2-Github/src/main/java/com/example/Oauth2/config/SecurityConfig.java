package com.example.Oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.oauth2Login(c -> {
            c.clientRegistrationRepository(clientRepository());
        });
        httpSecurity.authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        return httpSecurity.build();
    }

    private ClientRegistrationRepository clientRepository(){
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }

    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("1ac68f2deb3b04597050")
                .clientSecret("1820e84f21ca5ef436e00f26a502917e8e535a58")
                .build();
    }
}
