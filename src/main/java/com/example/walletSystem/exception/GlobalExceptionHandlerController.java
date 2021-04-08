package com.example.walletSystem.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.walletSystem.entity.ResponseAsEntity;



@RestControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {


  @ExceptionHandler(AccountNotFound.class)
  public ResponseEntity<Object> handleExceptions( AccountNotFound exception, WebRequest webRequest) {
	  ResponseAsEntity response = new ResponseAsEntity();
      response.setStatus("Not found");
      ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
      return entity;
  }
  
  @ExceptionHandler(CustomException.class)
  public void handleCustomException(HttpServletResponse res, CustomException ex) throws IOException {
    res.sendError(ex.getHttpStatus().value(), ex.getMessage());
  }

  
  @ExceptionHandler(Exception.class)
  public void handleException(HttpServletResponse res) throws IOException {
    res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
  }

}
