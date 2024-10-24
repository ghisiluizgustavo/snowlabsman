package me.ghisiluizgustavo.domain.rental.gateway;

import me.ghisiluizgustavo.domain.book.model.Book;
import me.ghisiluizgustavo.domain.customer.model.Customer;

import java.util.List;

public interface RentalNotificationGateway {

    void notifyRental(List<Book> book, Customer customer);

}
