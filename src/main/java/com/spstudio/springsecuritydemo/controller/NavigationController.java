package com.spstudio.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

	@GetMapping("/userSetting")
	public String login() {
		return "userSetting";
	}

}
