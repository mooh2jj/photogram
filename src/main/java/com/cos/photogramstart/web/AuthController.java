package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {		// @Valid에서 오류난 거
				errorMap.put(error.getField(), error.getDefaultMessage());	// bindingResult에 모아짐!				
				log.error("error.getDefaultMessage: {}", error.getDefaultMessage());
			}
			return "오류남";
		} else {
			log.info("signup 실행됨");
			log.info("signupDto: {}", signupDto.toString());
			User user = signupDto.toEntity();
			log.info("user: {}", user);
			
			User userEntity = authService.join(user);
			log.info("userEntity: {}", userEntity);
		}
		
		
		return "redirect:signin";
	}
}
