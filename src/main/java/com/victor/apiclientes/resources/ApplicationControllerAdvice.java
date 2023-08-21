package com.victor.apiclientes.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.victor.apiclientes.exception.ApiErros;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiErros handleValidationErros(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<String> messages = bindingResult.getAllErrors().stream().map(objError -> objError.getDefaultMessage()).collect(Collectors.toList());
		return new ApiErros(messages);
	}
	
	@ExceptionHandler
	public ResponseEntity<ApiErros> handleResponseStatusException(ResponseStatusException ex) {
		String msg = ex.getMessage();
		HttpStatusCode codStatus = ex.getStatusCode();
		ApiErros api = new ApiErros(msg);
		return new ResponseEntity<ApiErros>(api, codStatus);
	}

}
