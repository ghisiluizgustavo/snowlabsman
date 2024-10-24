package me.ghisiluizgustavo.domain.rental.exception;

public class BookNotAvailableException extends RuntimeException {

    public BookNotAvailableException(String message){
        super(message);
    }
}
