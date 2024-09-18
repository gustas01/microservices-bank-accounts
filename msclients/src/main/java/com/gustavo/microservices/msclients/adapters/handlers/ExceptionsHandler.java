package com.gustavo.microservices.msclients.adapters.handlers;

import com.gustavo.microservices.msclients.adapters.DTOs.StandardErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ExceptionsHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardErrorResponseDTO> validations(MethodArgumentNotValidException e){
    String error = "Bad request";
    HttpStatus status = HttpStatus.BAD_REQUEST;

    List<String> errors = new LinkedList<>();
    String[] errorsMsg = Objects.requireNonNull(e.getDetailMessageArguments())[1].toString().split(", and ");

    for (String s : errorsMsg)
      errors.add(s.split(": ")[1]);

    StandardErrorResponseDTO err = new StandardErrorResponseDTO(LocalDateTime.now(), status.value(), error, errors);
    return ResponseEntity.status(status).body(err);
  }
}
