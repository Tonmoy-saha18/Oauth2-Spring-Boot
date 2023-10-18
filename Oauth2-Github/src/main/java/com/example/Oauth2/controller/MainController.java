package com.example.Oauth2.controller;

import com.example.Oauth2.response.SecuredResponse;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class MainController {
    private final Logger logger = Logger.getLogger(MainController.class.getName());
    @GetMapping("/")
    public SecuredResponse indexController(OAuth2AuthenticationToken token){
        logger.info(String.valueOf(token.getPrincipal()));
        return new SecuredResponse().setSecuredText("Hey you are authenticated to watch the secured text");
    }
}
