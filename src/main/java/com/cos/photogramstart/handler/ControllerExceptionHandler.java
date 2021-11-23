package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@RestControllerAdvice
public class ControllerExceptionHandler {

//	@ExceptionHandler(RuntimeException.class)
//	public String validationException(RuntimeException e) {
//		return e.getMessage();	// throw new RuntimeException("유효성 검사 실패"); 을 낚아채서 json으로 뿌려줘
//	}
	
	// CustomValidationException으로 커스터마이징으로 정교하게 꾸밈.
//	@ExceptionHandler(CustomValidationException.class)
//	public Map<String, String> validationException(CustomValidationException e) {
//		return e.getErrorMap();	
//	}
	
//	@ExceptionHandler(CustomValidationException.class)
//	public CMRespDto validationException(CustomValidationException e) {
//		return new CMRespDto(e.getMessage(), e.getErrorMap());	
//	}
//	@ExceptionHandler(CustomValidationException.class)
//	public CMRespDto<Map<String, String>> validationException(CustomValidationException e) {
//		return new CMRespDto(-1, e.getMessage(), e.getErrorMap());	
//	}
	@ExceptionHandler(CustomValidationException.class)
	public CMRespDto<?> validationException(CustomValidationException e) {		// 제네릭으로 ?넣어서 쉽게 커스터마이징 할 수 있다.
		return new CMRespDto(-1, e.getMessage(), e.getErrorMap());	
	}
}
