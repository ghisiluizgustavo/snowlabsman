package me.ghisiluizgustavo.rental.gateway;

import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.customer.model.Customer;

import java.util.List;

public interface RentalNotificationGateway {

    void notifyRental(List<Book> book, Customer customer);

}
