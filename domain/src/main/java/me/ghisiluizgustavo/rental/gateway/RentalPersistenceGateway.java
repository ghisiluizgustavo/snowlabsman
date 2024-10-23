package me.ghisiluizgustavo.rental.gateway;

import me.ghisiluizgustavo.rental.model.Rental;

import java.util.List;

public interface RentalPersistenceGateway {

    List<Rental> rentBooks(List<Rental> rentals);

}
