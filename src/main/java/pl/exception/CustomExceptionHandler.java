package pl.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity handleAllExceptions (Exception exception) {
    return ResponseEntity.status(BAD_REQUEST)
      .body(Map.of("Server Error", Collections.singletonList(exception.getMessage())));
  }

  @Override
  public ResponseEntity handleMethodArgumentNotValid (MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
    return ResponseEntity
      .status(BAD_REQUEST)
      .body(exception.getBindingResult().getAllErrors().stream().collect(Collectors.groupingBy(ObjectError::getObjectName, Collectors.mapping(ObjectError::getDefaultMessage, Collectors.toList()))));
  }
}
