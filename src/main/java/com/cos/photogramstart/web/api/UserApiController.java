package com.cos.photogramstart.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMRespDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;
	
	@PutMapping("/api/user/{id}")
	public CMRespDto<?> update(
			@PathVariable Long id, 
			@Valid UserUpdateDto userUpdateDto,
			BindingResult bindingResult, // 꼭 @Valid 붙여진 파라미터 다음에 해야 적용죔 - 좀 잘못만들어진 케이스;;
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println(userUpdateDto);
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {		// @Valid에서 오류난 거
				errorMap.put(error.getField(), error.getDefaultMessage());	// bindingResult에 모아짐!				
				log.error("error.getDefaultMessage: {}", error.getDefaultMessage());
			}
			throw new CustomValidationApiException("유효성 검사 실패", errorMap);
		}else {
			
			User userEntity =  userService.userUpdate(id, userUpdateDto.toEntity());
			principalDetails.setUser(userEntity);		// 세션정보 변경
			return new CMRespDto<>(1, "회원수정완료", userEntity);
		}
		
	}
}
