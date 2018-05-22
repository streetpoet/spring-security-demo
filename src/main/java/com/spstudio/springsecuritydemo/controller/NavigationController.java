package com.spstudio.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
	@GetMapping("/userSetting")
	public String us() {
		return "userSetting";
	}

	@GetMapping("/userSetting2")
	public String us2() {
		return "userSetting2";
	}

	@GetMapping("/login2")
	public String login2() {
		return "login2";
	}
}
