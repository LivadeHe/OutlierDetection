package io.swagger.api;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

import io.swagger.model.Error;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<String> errorMessages = ex.getBindingResult().getAllErrors().stream()
                .map(ObjectError -> ObjectError.getDefaultMessage())
                .collect(Collectors.toList());

        Error errorResponse = new Error();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setMessage(String.join(", ", errorMessages));
        errorResponse.setTimestamp(OffsetDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<Error> handleValidationExceptions(RuntimeException e) {
        Error error = new Error();
        error.setCode("400");
        error.setMessage("Validation error: " + e.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Error> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        Error error = new Error();
        error.setCode("400");
        error.setMessage("Invalid type for parameter " + e.getName() + ": " + e.getValue());
        error.setTimestamp(OffsetDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Error errorResponse = new Error();
        errorResponse.setCode("404");
        errorResponse.setMessage("Page not found: " + e.getRequestURL());
        errorResponse.setTimestamp(OffsetDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Error> handleNotFoundException(NoSuchElementException e) {
        Error error = new Error();
        error.setCode("404");
        error.setMessage("Resource not found: " + e.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleInternalServerError(Exception e) {
        Error error = new Error();
        error.setCode("500");
        error.setMessage("Internal Server Error: " + e.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String customMessage = "Invalid input format";

        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException ifEx = (InvalidFormatException) ex.getCause();
            String fieldName = ifEx.getPath().stream()
                    .map(ref -> ref.getFieldName())
                    .collect(Collectors.joining(", "));

            customMessage = "Invalid input for " + fieldName + "; expected type " + ifEx.getTargetType().getSimpleName();
        }

        Error errorResponse = new Error();
        errorResponse.setCode("400");
        errorResponse.setMessage(customMessage);
        errorResponse.setTimestamp(OffsetDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
