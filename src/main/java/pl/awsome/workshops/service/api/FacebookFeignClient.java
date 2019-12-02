package pl.awsome.workshops.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pl.awsome.workshops.service.api.model.FacebookObject;

@FeignClient(name = "graph-api", url = "https://graph.facebook.com/v5.0")
public interface FacebookFeignClient {

    @GetMapping(value = "/me")
    FacebookObject getFeeds(@RequestParam String fields, @RequestHeader("Authorization") String accessToken);
}

