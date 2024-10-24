package me.ghisiluizgustavo.rental.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.rental.RentBooksUseCase;
import me.ghisiluizgustavo.rental.dto.RentBooksDTO;
import me.ghisiluizgustavo.rental.dto.RentalBookResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rental")
public class RentalBooksController {

    private final RentBooksUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RentalBookResponseDTO rentBook(@RequestBody @Valid RentBooksDTO rentBooksDTO){
        return new RentalBookResponseDTO(useCase.execute(rentBooksDTO));
    }
}
