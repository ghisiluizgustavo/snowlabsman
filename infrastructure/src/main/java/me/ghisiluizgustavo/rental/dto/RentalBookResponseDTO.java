package me.ghisiluizgustavo.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ghisiluizgustavo.book.dto.BookResponseDTO;

import me.ghisiluizgustavo.customer.dto.CustomerResponseDTO;
import me.ghisiluizgustavo.rental.model.Rental;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
