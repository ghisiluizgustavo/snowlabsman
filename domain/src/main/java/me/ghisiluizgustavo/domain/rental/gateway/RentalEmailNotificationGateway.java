package me.ghisiluizgustavo.domain.rental.gateway;

import me.ghisiluizgustavo.domain.customer.model.Customer;

public interface RentalEmailNotificationGateway {
    void sendEmail(Customer customer, String message);
}
