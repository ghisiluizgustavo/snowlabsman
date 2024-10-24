package me.ghisiluizgustavo.domain.rental.gateway;

import me.ghisiluizgustavo.domain.rental.model.Rental;

import java.util.List;

public interface RentalPersistenceGateway {

    List<Rental> rentBooks(List<Rental> rentals);

}
