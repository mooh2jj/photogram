package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/{id}")		
	public String profile(@PathVariable Long id) {
		return "user/profile";
	}
	
	@GetMapping("/{id}/update")
	public String update(@PathVariable Long id) {
		return "user/update";
	}
	
}
