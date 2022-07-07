package com.app.exception;

import java.util.List;

import lombok.Data;

@Data
public class ExceptionOutput {
	private String errorCode;//"error_code": "000456",
	private List<String> errors;
}
