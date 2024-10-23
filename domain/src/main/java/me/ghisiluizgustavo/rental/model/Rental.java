package me.ghisiluizgustavo.rental.model;

import me.ghisiluizgustavo.ID;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.customer.model.Customer;
import me.ghisiluizgustavo.rental.exception.BookNotAvailableException;

import java.time.LocalDateTime;
import java.util.List;

public record Rental(ID id, Customer customer, Book book, LocalDateTime rentalDate, LocalDateTime devolutionDate) {
    public Rental {
        if (customer == null) {
            throw new IllegalArgumentException("To rent books is needed a customer");
        }
        if (book == null) {
            throw new IllegalArgumentException("To rent books is needed at least one book");
        }

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("The book " + book.name() + " is not available to be rent");
        }
    }
}
