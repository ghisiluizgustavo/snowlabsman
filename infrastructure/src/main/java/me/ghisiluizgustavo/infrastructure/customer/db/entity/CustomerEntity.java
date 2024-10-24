package me.ghisiluizgustavo.infrastructure.customer.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ghisiluizgustavo.domain.ID;
import me.ghisiluizgustavo.domain.customer.model.Customer;
import me.ghisiluizgustavo.infrastructure.rental.db.entity.RentalEntity;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<RentalEntity> rentals;

    public CustomerEntity(Customer customer) {
        this.id = customer.id().value();
        this.name = customer.name();
        this.email = customer.email();
    }

    public Customer toCustomer() {
        return new Customer(
                new ID(this.id),
                this.name,
                this.email
        );
    }
}
