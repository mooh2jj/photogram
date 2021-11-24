package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {

	@GetMapping({"/", "/image/story"})		// 로그인 완료후 이쪽으로 옴!
	public String stroy() {
		return "image/story";
	}
	
	@GetMapping("/image/popular")		
	public String popular() {
		return "image/popular";
	}
	
	
	@GetMapping("/image/upload")		
	public String upload() {
		return "image/upload";
	}
}
