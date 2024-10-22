package me.ghisiluizgustavo.rental.model;

import me.ghisiluizgustavo.ID;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.customer.model.Customer;
import me.ghisiluizgustavo.rental.exception.BookNotAvailableException;

import java.util.List;

public record Rental(ID id, Customer customer, List<Book> books) {
    public Rental {
        if (customer == null) {
            throw new IllegalArgumentException("To rent books is needed a customer");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("To rent books is needed at least one book");
        }

        checkBooksAvailability();
    }

    private void checkBooksAvailability() {
        books.stream()
                .filter(book -> !book.isAvailable())
                .findAny()
                .ifPresent(book -> {
                    throw new BookNotAvailableException(
                            "The book " + book.name() + " is not available to be rent"
                    );
                });
    }
}
