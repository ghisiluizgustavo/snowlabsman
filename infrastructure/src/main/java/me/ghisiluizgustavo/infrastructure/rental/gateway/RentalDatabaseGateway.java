package me.ghisiluizgustavo.infrastructure.rental.gateway;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.infrastructure.book.db.entity.BookEntity;
import me.ghisiluizgustavo.infrastructure.book.db.repository.BookRepository;
import me.ghisiluizgustavo.domain.book.exception.BookNotFoundException;
import me.ghisiluizgustavo.infrastructure.customer.db.entity.CustomerEntity;
import me.ghisiluizgustavo.infrastructure.customer.db.repository.CustomerRepository;
import me.ghisiluizgustavo.domain.customer.exception.CustomerNotFoundException;
import me.ghisiluizgustavo.domain.customer.gateway.CustomerPersistenceGateway;
import me.ghisiluizgustavo.domain.rental.gateway.RentalPersistenceGateway;
import me.ghisiluizgustavo.infrastructure.rental.db.entity.RentalEntity;
import me.ghisiluizgustavo.infrastructure.rental.db.repository.RentalRepository;
import me.ghisiluizgustavo.domain.rental.model.Rental;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RentalDatabaseGateway implements RentalPersistenceGateway {

    private final RentalRepository rentalRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    private final CustomerPersistenceGateway customerPersistenceGateway;

    @Override
    public List<Rental> rentBooks(List<Rental> rentals) {
        return rentals.stream()
                .map(rental -> {
                    CustomerEntity customerEntity = customerRepository.findById(rental.customer().id().value())
                            .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

                    BookEntity bookEntity = bookRepository.findById(rental.book().id().value())
                            .orElseThrow(() -> new BookNotFoundException("Book not found"));

                    RentalEntity rentalEntity = new RentalEntity();
                    rentalEntity.setCustomer(customerEntity);
                    rentalEntity.setBook(bookEntity);
                    rentalEntity.setRentalDate(rental.rentalDate());
                    rentalEntity.setDevolutionDate(rental.devolutionDate());

                    return rentalRepository.save(rentalEntity);
                })
                .map(RentalEntity::toRental)
                .collect(Collectors.toList());
    }
}
