package com.cos.photogramstart.web.dto;

import java.util.Map;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CMRespDto<T> {
	
	private int code;		// 1: 성공, -1: 실패
	private String message;
//	private Map<String, String> errorMap;
	
	private T data;

}
