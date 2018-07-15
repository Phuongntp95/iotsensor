package com.example.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EndPoint;

@ControllerAdvice
@RestController
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public EndPoint<Object> exceptionHandler(Exception exception){
		return new EndPoint<Object>(HttpStatus.NOT_FOUND.value(), exception.getMessage(), null);
	}
}
