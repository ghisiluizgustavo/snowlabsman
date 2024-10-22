package me.ghisiluizgustavo.book.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IsbnTest {

    @Test
    public void shouldThrownExceptionWhenIsbnIsInvalid(){
        IllegalArgumentException ex =
                Assertions.assertThrows(IllegalArgumentException.class, () -> new Isbn("1234567890"));

        assertEquals(
                "The first three digits (EAN) of ISBN are invalid, should be 978 or 979",
                ex.getMessage()
        );
    }

    @Test
    public void shouldCreateISBN(){
        var isbn = new Isbn("9788192839");

        assertNotNull(isbn);
        assertEquals("9788192839", isbn.value());
    }
}
