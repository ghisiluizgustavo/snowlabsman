package me.ghisiluizgustavo.book.model;

import me.ghisiluizgustavo.domain.ID;
import me.ghisiluizgustavo.domain.book.model.Book;
import me.ghisiluizgustavo.domain.book.model.Isbn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void shouldCreateBook() {
        var book = new Book(
                new ID(UUID.randomUUID().toString()),
                new Isbn("978999"),
                "Clean Code",
                "Uncle Bob",
                true);

        assertNotNull(book);
        assertEquals("Clean Code", book.name());
        assertEquals("Uncle Bob", book.author());
        assertTrue(book.available());
    }

    @Test
    public void shouldThrownExceptionWhenIsbnIsNull(){
        IllegalArgumentException ex =
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new Book(
                                new ID(UUID.randomUUID().toString()),
                                null,
                                "Clean Code",
                                "Uncle Bob",
                                true)
                );

        assertEquals("The book ISBN is a mandatory field", ex.getMessage());
    }

    @Test
    public void shouldThrownExceptionWhenNameIsBlank(){
        IllegalArgumentException ex =
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new Book(
                                new ID(UUID.randomUUID().toString()),
                                new Isbn("978999999"),
                                "",
                                "Uncle Bob",
                                true)
                );

        assertEquals("The book name is a mandatory field", ex.getMessage());
    }

    @Test
    public void shouldThrownExceptionWhenAuthorNameIsBlank(){
        IllegalArgumentException ex =
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new Book(
                                new ID(UUID.randomUUID().toString()),
                                new Isbn("978999999"),
                                "Clean Code",
                                "",
                                true)
                );

        assertEquals("The book author is a mandatory field", ex.getMessage());
    }

}
