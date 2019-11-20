package pl.awsome.workshops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping(value = "/hello-rest", method = RequestMethod.GET)
    String returnHello() {
        return "Hello world" ;
    }

}
