package org.cca.com.GKJAVARESTFULTEST.ResponseUtil;

import org.cca.com.GKJAVARESTFULTEST.dto.response.ErrorResponseDto;
import org.cca.com.GKJAVARESTFULTEST.dto.response.SuccessResponseDto;

public class ResponseUtil {

	public static SuccessResponseDto<Object> success(){
		return new SuccessResponseDto<Object>();
	}
	
	public static ErrorResponseDto error(){
		return new ErrorResponseDto();
	}
}