package me.ghisiluizgustavo.infrastructure.rental.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ghisiluizgustavo.domain.ID;
import me.ghisiluizgustavo.infrastructure.book.db.entity.BookEntity;
import me.ghisiluizgustavo.infrastructure.customer.db.entity.CustomerEntity;
import me.ghisiluizgustavo.domain.rental.model.Rental;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private BookEntity book;

    private LocalDateTime rentalDate;
    private LocalDateTime devolutionDate;

    public RentalEntity(Rental rental) {
        this.customer = new CustomerEntity(rental.customer());
        this.book = new BookEntity(rental.book());
        this.rentalDate = rental.rentalDate();
        this.devolutionDate = rental.devolutionDate();
    }

    public Rental toRental() {
        return new Rental(
                new ID(this.id),
                this.customer.toCustomer(),
                this.book.toBook(),
                this.rentalDate,
                this.devolutionDate
        );
    }

}
