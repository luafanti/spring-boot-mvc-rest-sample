package pl.awsome.workshops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.awsome.workshops.service.FacebookService;
import pl.awsome.workshops.service.api.model.FacebookObject;

@Controller
public class FacebookFeedController {

    @Autowired
    FacebookService facebookService;

    @GetMapping(value = "/feed")
    public String getFacebookFeeds(Model model){
        FacebookObject facebookFeeds = facebookService.getFacebookFeeds();
        model.addAttribute("feeds",facebookFeeds.getFeed().getData());
        return "facebook-feed";
    }
}
