package me.ghisiluizgustavo.rental.model;

import me.ghisiluizgustavo.ID;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.book.model.Isbn;
import me.ghisiluizgustavo.customer.model.Customer;
import me.ghisiluizgustavo.rental.exception.BookNotAvailableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class RentalTest {

    @Test
    public void shouldCreateRental() {
        List<Book> books = List.of(new Book(
                        new ID(UUID.randomUUID().toString()),
                        new Isbn("978123123"),
                        "Clean Code",
                        "Uncle Bob",
                        true
                )
        );
        var rental = new Rental(
                new ID(UUID.randomUUID().toString()),
                new Customer(new ID(UUID.randomUUID().toString()), "John"),
                books
        );

        assertNotNull(rental);
        assertEquals("Clean Code", rental.books().get(0).name());
        assertEquals("Uncle Bob", rental.books().get(0).author());
        assertEquals("John", rental.customer().name());
    }

    @Test
    public void shouldThrownExceptionWhenCustomerIsNull(){
        List<Book> books = List.of(new Book(
                        new ID(UUID.randomUUID().toString()),
                        new Isbn("978123123"),
                        "Clean Code",
                        "Uncle Bob",
                        true
                )
        );

        IllegalArgumentException ex =
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new Rental(
                                new ID(UUID.randomUUID().toString()),
                                null,
                                books
                        )
                );

        assertEquals("To rent books is needed a customer", ex.getMessage());
    }

    @Test
    public void shouldThrownExceptionWhenBooksIsNullOrEmpty(){
        IllegalArgumentException ex =
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new Rental(
                                new ID(UUID.randomUUID().toString()),
                                new Customer(new ID(UUID.randomUUID().toString()), "John"),
                                new ArrayList<>()
                        )
                );

        assertEquals("To rent books is needed at least one book", ex.getMessage());
    }

    @Test
    public void shouldThrownExceptionWhenBooksIsNotAvailable(){
        List<Book> books = List.of(new Book(
                        new ID(UUID.randomUUID().toString()),
                        new Isbn("978123123"),
                        "Clean Code",
                        "Uncle Bob",
                        false
                )
        );

        BookNotAvailableException ex =
                Assertions.assertThrows(BookNotAvailableException.class, () ->
                        new Rental(
                                new ID(UUID.randomUUID().toString()),
                                new Customer(new ID(UUID.randomUUID().toString()), "John"),
                                books
                        )
                );

        assertEquals("The book Clean Code is not available to be rent", ex.getMessage());
    }
}
