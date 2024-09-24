package com.gustavo.microservices.msclients.adapters.handlers;

import com.gustavo.microservices.msclients.adapters.DTOs.StandardErrorResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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
    HttpStatus status = HttpStatus.BAD_REQUEST;

    List<String> errors = new LinkedList<>();
    String[] errorsMsg = Objects.requireNonNull(e.getDetailMessageArguments())[1].toString().split(", and ");

    for (String s : errorsMsg)
      errors.add(s.split(": ")[1]);

    StandardErrorResponseDTO err = new StandardErrorResponseDTO(LocalDateTime.now(), status.value(), errors);
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<StandardErrorResponseDTO> entityNotFound(EntityNotFoundException e){
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardErrorResponseDTO err = new StandardErrorResponseDTO(LocalDateTime.now(), status.value(), e.getMessage());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(DateTimeParseException.class)
  public ResponseEntity<StandardErrorResponseDTO> handleHttpMessageNotReadableException(DateTimeParseException ex) {
    String message = "Formato de data inválido. O formato esperado é yyyy-MM-dd.";
    HttpStatus status = HttpStatus.BAD_REQUEST;

    StandardErrorResponseDTO err = new StandardErrorResponseDTO(LocalDateTime.now(), status.value(), message);
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<StandardErrorResponseDTO> handleConstraintViolationException(DataIntegrityViolationException e){
    String message = "";
    if(e.getMessage().contains("(cpf)=")) message = "CPF já cadastrado!";
    else message = "Email já cadastrado!";
    HttpStatus status = HttpStatus.CONFLICT;
    StandardErrorResponseDTO err = new StandardErrorResponseDTO(LocalDateTime.now(), status.value(), message);
    return ResponseEntity.status(status).body(err);
  }
}
