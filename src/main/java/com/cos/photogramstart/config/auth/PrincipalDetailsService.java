package com.cos.photogramstart.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	// 1. 패스워드는 알아서 채킹해서 신경쓸 필요 x
	// 2. 리턴이 잘되면 자동으로 UserDetails타입을 세션으로 만든다.
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username만 신경쓰면 됨.
		log.info("loadUserByUsername 실행됨!");
		User userEntity = userRepository.findByUsername(username);
		
		if(userEntity == null) {
			return null;			
		}else {
			return new PrincipalDetails(userEntity);		// UserDetails를 반환 -> 지저분하니까 PrincipalDetails를 따로 만듦
		}
	}

}
