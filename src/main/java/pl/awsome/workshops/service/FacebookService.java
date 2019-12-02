package pl.awsome.workshops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.awsome.workshops.service.api.FacebookFeignClient;
import pl.awsome.workshops.service.api.model.FacebookObject;

@Service
public class FacebookService {

    private static final String FILED_PARAM = "feed{full_picture,message}";
    private static final String TOKEN_TYPE = "Bearer ";

    @Autowired
    FacebookFeignClient facebookFeignClient;

    @Autowired
    AuthorizationService authorizationService;

    public FacebookObject getFacebookFeeds() {
        return facebookFeignClient.getFeeds(FILED_PARAM, TOKEN_TYPE + authorizationService.getAccessToken());
    }
}
