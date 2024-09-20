package com.gustavo.microservices.msclients.adapters.handlers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gustavo.microservices.msclients.adapters.DTOs.StandardErrorResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
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

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<StandardErrorResponseDTO> entityNotFound(EntityNotFoundException e){
    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardErrorResponseDTO err = new StandardErrorResponseDTO(LocalDateTime.now(), status.value(), error, e.getMessage());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    // Verifica se a causa foi um problema de parsing de data
    Throwable cause = ex.getCause();
    if (cause.getCause() instanceof DateTimeParseException) {
      return new ResponseEntity<>("Formato de data inválido. O formato esperado é yyyy-MM-dd.", HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>("Erro ao processar a requisição.", HttpStatus.BAD_REQUEST);
  }
}
