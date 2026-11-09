package br.edu.hospitalar.controller;

import br.edu.hospitalar.model.ApiError;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.converter.HttpMessageNotReadableException;

@RestControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiError> badRequest(IllegalArgumentException ex) { return ResponseEntity.badRequest().body(new ApiError(ex.getMessage())); }
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ApiError> invalidJson(HttpMessageNotReadableException ex) { return ResponseEntity.badRequest().body(new ApiError("JSON inválido ou enum/data em formato não reconhecido")); }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> serverError(Exception ex) { return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("Erro interno na API")); }
}
