package com.nissan.common;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class APIResponse {

	private Integer status;		// 200, 401.....
	
	private Object data;		// emailId, roleId
	
	private Object error;		// error message
	
	public APIResponse() {
		status = HttpStatus.OK.value();
	}
	
}
