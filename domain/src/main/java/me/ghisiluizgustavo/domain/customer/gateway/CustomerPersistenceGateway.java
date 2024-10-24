package me.ghisiluizgustavo.domain.customer.gateway;

import me.ghisiluizgustavo.domain.customer.model.Customer;

public interface CustomerPersistenceGateway {

    Customer findById(String id);

}
