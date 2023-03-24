package com.jeremias.dev.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeremias.dev.response.FileStatusResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<?> handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
		System.out.printf(e.getMessage());
	
		return new ResponseEntity<>( new FileStatusResponse(false,  e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> handleError2(IOException e) {
		System.out.printf(e.getMessage());
		
		return new ResponseEntity<>( new FileStatusResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	 * @ExceptionHandler(MultipartException.class) public String
	 * handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
	 * System.out.printf(e.getMessage());
	 * redirectAttributes.addFlashAttribute("message", e.getMessage()); return
	 * "redirect:/uploadStatus"; }
	 */
}
