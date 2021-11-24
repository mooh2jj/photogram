package com.cos.photogramstart.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public User userUpdate(Long id, User user) {
		
		// 1. 영속화
		User userEntity = userRepository.findById(id)
				.orElseThrow(() -> {return new CustomValidationApiException("찾을 수 없는 id입니다.");});
		// 2. 영속화된 오브젝트를 수정 - 더티체킹(업데이트 완료)
		userEntity.setName(user.getName());
		userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));		// 애도 암호화!
		userEntity.setBio(user.getBio());
		userEntity.setWebsite(user.getWebsite());
		userEntity.setPhone(user.getPhone());
		userEntity.setGender(user.getGender());
		return userEntity;
	}
}
