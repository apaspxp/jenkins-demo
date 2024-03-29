package com.waterco.jenkinsdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {

    @RequestMapping(value = "hellojenkins", method = RequestMethod.GET)
    public String hello() {
        return "Hello from Jenkins Controller class.";
    }

    @RequestMapping(value = "byejenkins", method = RequestMethod.GET)
    public String bye() {
        return "Bye from Jenkins Controller class.";
    }

    @RequestMapping(value = "testjenkins", method = RequestMethod.GET)
    public String testJenkins() {
        return "Test from Jenkins Controller class. Adding some more text for demo second time.";
    }

    @RequestMapping(value = "buildjenkins", method = RequestMethod.GET)
    public String buildJenkins() {
        return "Build jenkins from Jenkins Controller class...";
    }
}
