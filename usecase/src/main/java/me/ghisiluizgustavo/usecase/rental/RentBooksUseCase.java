package me.ghisiluizgustavo.usecase.rental;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.domain.book.gateway.BookPersistenceGateway;
import me.ghisiluizgustavo.domain.book.model.Book;
import me.ghisiluizgustavo.domain.customer.gateway.CustomerPersistenceGateway;
import me.ghisiluizgustavo.domain.customer.model.Customer;
import me.ghisiluizgustavo.usecase.rental.dto.IRentBooks;
import me.ghisiluizgustavo.domain.rental.gateway.RentalEmailNotificationGateway;
import me.ghisiluizgustavo.domain.rental.gateway.RentalNotificationGateway;
import me.ghisiluizgustavo.domain.rental.gateway.RentalPersistenceGateway;
import me.ghisiluizgustavo.domain.rental.model.Rental;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RentBooksUseCase {

    private final RentalPersistenceGateway rentalPersistenceGateway;
    private final CustomerPersistenceGateway customerPersistenceGateway;
    private final BookPersistenceGateway bookPersistenceGateway;
    private final RentalNotificationGateway rentalNotificationGateway;
    private final RentalEmailNotificationGateway rentalEmailNotificationGateway;

    public List<Rental> execute(IRentBooks rentBooks){
        Customer customer = customerPersistenceGateway.findById(rentBooks.customerId());
        List<Book> books = rentBooks.booksIds().stream().map(bookPersistenceGateway::findById).toList();

        List<Rental> rentals = new ArrayList<>();
        for (Book book : books){
            rentals.add(new Rental(null, customer, book, LocalDateTime.now(), LocalDateTime.now().plusDays(20)));
        }

        List<Rental> rentalsSaved = rentalPersistenceGateway.rentBooks(rentals);

        books.forEach(book -> bookPersistenceGateway.makeUnavailable(book.id().value()));
        rentalNotificationGateway.notifyRental(books, customer);
        rentalEmailNotificationGateway.sendEmail(
                customer,
                "You successfully rented " + books.size() + " book(s)"
        );

        return rentalsSaved;
    }

}
