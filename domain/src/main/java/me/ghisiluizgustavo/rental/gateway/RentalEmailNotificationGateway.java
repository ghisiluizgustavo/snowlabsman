package me.ghisiluizgustavo.rental.gateway;

import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.customer.model.Customer;

import java.util.List;

public interface RentalEmailNotificationGateway {
    void sendEmail(Customer customer, String message);
}
