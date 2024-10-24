package me.ghisiluizgustavo.infrastructure.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ghisiluizgustavo.infrastructure.book.dto.BookResponseDTO;

import me.ghisiluizgustavo.infrastructure.customer.dto.CustomerResponseDTO;
import me.ghisiluizgustavo.domain.rental.model.Rental;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalBookResponseDTO {

    private String id;
    private CustomerResponseDTO customer;
    private List<BookResponseDTO> books;

    public RentalBookResponseDTO(List<Rental> rentals) {
        this.setId(rentals.get(0).id().value());
        this.setCustomer(new CustomerResponseDTO(rentals.get(0).customer()));
        List<BookResponseDTO> books = new ArrayList<>();
        for(Rental rental : rentals){
            books.add(new BookResponseDTO(rental.book()));
        }
        this.setBooks(books);
    }
}
