package me.ghisiluizgustavo.rental.event.model;

import lombok.Getter;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.customer.model.Customer;
import org.springframework.context.ApplicationEvent;

import java.util.List;

@Getter
public class RentalEvent extends ApplicationEvent {

    private final List<Book> book;
    private final Customer customer;
    private final StatusEventRental status;


    public RentalEvent(Object source, List<Book> book, Customer customer, StatusEventRental status) {
        super(source);
        this.book = book;
        this.status = status;
        this.customer = customer;
    }

}
