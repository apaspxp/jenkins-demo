package com.waterco.jenkinsdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {

	@RequestMapping("hellojenkins")
	public String hello() {
		return "Hello from Jenkins Controller class";
	}
	
	@RequestMapping("byejenkins")
	public String bye() {
		return "Bye from Jenkins Controller class";
	}
}