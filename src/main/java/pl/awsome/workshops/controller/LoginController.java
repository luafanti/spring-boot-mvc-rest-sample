package pl.awsome.workshops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.awsome.workshops.service.AuthorizationService;


@RestController
public class LoginController {

    @Autowired
    AuthorizationService authorizationService;

    @RequestMapping("/")
    String mainPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        String accessToken = authorizationService.getAccessToken();
        String userName = getUserName(user);
        return "Hello " + userName + " Your accessToken: " + accessToken;
    }

    private String getUserName(DefaultOAuth2User user) {
        if(user.getAttributes().containsKey("name")){
            return user.getAttributes().get("name").toString();
        }else {
            return user.getName();
        }
    }

}
