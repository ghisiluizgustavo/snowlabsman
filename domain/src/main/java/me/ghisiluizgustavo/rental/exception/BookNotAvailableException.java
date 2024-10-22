package me.ghisiluizgustavo.rental.exception;

public class BookNotAvailableException extends RuntimeException {

    public BookNotAvailableException(String message){
        super(message);
    }
}
