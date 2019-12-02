package pl.awsome.workshops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    public  String getAccessToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();
            if (clientRegistrationId.equals("facebook") || clientRegistrationId.equals("google")) {
                OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(clientRegistrationId, oauthToken.getName());
                accessToken = client.getAccessToken().getTokenValue();
            }
        }
        return accessToken;
    }
}
