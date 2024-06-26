package com.pragma.arquetipobootcamp2024.configuration.exceptionhandler;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyNotFoundException;
import com.pragma.arquetipobootcamp2024.configuration.Constants;
import com.pragma.arquetipobootcamp2024.domain.exception.DescriptionFieldExceedException;
import com.pragma.arquetipobootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.arquetipobootcamp2024.domain.exception.FieldLengthExceededException;
import com.pragma.arquetipobootcamp2024.domain.exception.NegativeNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.EMPTY_FIELD_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(NegativeNotAllowedException.class)
    public ResponseEntity<ExceptionResponse> handleNegativeNotAllowedException(NegativeNotAllowedException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNoDataFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.NO_DATA_FOUND_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(TechnologyAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleTechnologyAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleElementNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(TechnologyNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTechnologyNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.DESCRIPTION_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(FieldLengthExceededException.class)
    public ResponseEntity<ExceptionResponse> handleTechnologyNameLengthExceedException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.NAME_LENGTH_EXCEED_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(DescriptionFieldExceedException.class)
    public ResponseEntity<ExceptionResponse> handleTechnologyDescriptionLengthExceedException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.DESCRIPTION_LENGTH_EXCEED_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }

}
