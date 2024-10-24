package me.ghisiluizgustavo.infrastructure.config;

import me.ghisiluizgustavo.domain.book.exception.BookNotFoundException;
import me.ghisiluizgustavo.domain.customer.exception.CustomerNotFoundException;
import me.ghisiluizgustavo.domain.rental.exception.BookNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class, CustomerNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex, WebRequest req) {
        var errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotAvailableException.class)
    public ResponseEntity<ErrorResponse> handleBookNotAvailableException(Exception ex, WebRequest req) {
        var errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
