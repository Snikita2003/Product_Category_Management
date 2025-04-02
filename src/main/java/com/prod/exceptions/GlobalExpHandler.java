package com.prod.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prod.repo.Responce;


@RestControllerAdvice
public class GlobalExpHandler {

	@ExceptionHandler( ResourceNotFoundException.class)
	public  ResponseEntity<Responce> resNotFoundExpHandler( ResourceNotFoundException ex)
	{
		String msg= ex.getMessage();
		Responce responce=new Responce(msg,-1L);
		return ResponseEntity.ok(responce);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidExp(MethodArgumentNotValidException  ex)
	{
		Map<String, String> errors=new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((e)->{
			
			String fname=  (( FieldError) e).getField() ;
			String msg=e.getDefaultMessage();
			errors.put(fname,msg);
		});
		
		
		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
	}
	
}
	