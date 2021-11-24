package com.cos.photogramstart.web.dto.user;


import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class UserUpdateDto {

	private String name;	// 필수
	private String password;	// 필수
	private String website;
	private String bio;
	private String phone;
	private String gender;
	
	// 조금 위험 : 코드 수정 불가피
	public User toEntity() {
		return User.builder()
				.name(name)				// validation 체크해야
				.password(password)		// validation 체크해야
				.website(website)
				.bio(bio)
				.phone(phone)
				.gender(gender)
				.build();
	}
	
}
