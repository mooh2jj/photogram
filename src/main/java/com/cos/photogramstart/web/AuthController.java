package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final  AuthService authService;
	
	@GetMapping("/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	@PostMapping("/signup")
	public String signup(SignupDto signupDto) {
		log.info("signup 실행됨");
		log.info("signupDto: {}", signupDto.toString());
		User user = signupDto.toEntity();
		log.info("user: {}", user);
		
		User userEntity = authService.join(user);
		log.info("userEntity: {}", userEntity);
		return "redirect:signin";
	}
}
