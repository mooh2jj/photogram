package com.cos.photogramstart.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;

	@Transactional
	public User join(User user) {
		
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		User userEntity = userRepository.save(user);
		return userEntity;
	}
	
	
	
	
	
	
}
