package me.ghisiluizgustavo.customer.gateway;

import me.ghisiluizgustavo.customer.model.Customer;
import me.ghisiluizgustavo.rental.model.Rental;

public interface CustomerPersistenceGateway {

    Customer findById(String id);

}
