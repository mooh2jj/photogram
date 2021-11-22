package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping("/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	@PostMapping("/signup")
	public String signup() {
		log.info("signup 실행됨");
		return "redirect:signin";
	}
}
