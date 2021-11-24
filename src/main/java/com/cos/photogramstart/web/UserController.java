package com.cos.photogramstart.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.photogramstart.config.auth.PrincipalDetails;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/{id}")		
	public String profile(@PathVariable Long id) {
		return "user/profile";
	}
	
//	@GetMapping("/{id}/update")
//	public String update(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
//		// 세션 접근
//		System.out.println("세션정보: " + principalDetails.getUser());
//		
//		model.addAttribute("principal", principalDetails.getUser());
//		return "user/update";
//	}
	@GetMapping("/{id}/update")
	public String update(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		// 세션 접근
		System.out.println("세션정보: " + principalDetails.getUser());
		
		return "user/update";
	}
	
}
