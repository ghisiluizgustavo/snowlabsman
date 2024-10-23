package me.ghisiluizgustavo.customer.gateway;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.db.entity.BookEntity;
import me.ghisiluizgustavo.book.exception.BookNotFoundException;
import me.ghisiluizgustavo.customer.db.entity.CustomerEntity;
import me.ghisiluizgustavo.customer.db.repository.CustomerRepository;
import me.ghisiluizgustavo.customer.exception.CustomerNotFoundException;
import me.ghisiluizgustavo.customer.model.Customer;
import me.ghisiluizgustavo.rental.model.Rental;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDatabaseGateway implements CustomerPersistenceGateway {

    private final CustomerRepository customerRepository;


    @Override
    public Customer findById(String id) {
        return customerRepository
                .findById(id)
                .map(CustomerEntity::toCustomer)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " was not found"));
    }

}
