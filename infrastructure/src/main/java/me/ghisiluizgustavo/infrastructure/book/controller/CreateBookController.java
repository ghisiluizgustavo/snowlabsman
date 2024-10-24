package me.ghisiluizgustavo.infrastructure.book.controller;

import me.ghisiluizgustavo.usecase.book.CreateBookUseCase;
import me.ghisiluizgustavo.infrastructure.book.dto.BookResponseDTO;
import me.ghisiluizgustavo.infrastructure.book.dto.CreateBookDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class CreateBookController {

    private final CreateBookUseCase useCase;

    @PostMapping
    public BookResponseDTO createBook(@Valid @RequestBody CreateBookDTO book){
        return new BookResponseDTO(useCase.execute(book));
    };
}
