package me.ghisiluizgustavo.usecase.rental.dto;

import java.util.List;

public interface IRentBooks {
    String customerId();
    List<String> booksIds();
}
