package me.ghisiluizgustavo.book.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.CreateBookUseCase;
import me.ghisiluizgustavo.book.UpdateBookUseCase;
import me.ghisiluizgustavo.book.dto.BookResponseDTO;
import me.ghisiluizgustavo.book.dto.CreateBookDTO;
import me.ghisiluizgustavo.book.dto.UpdateBookDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class UpdateBookController {

    private final UpdateBookUseCase useCase;

    @PutMapping("/{id}")
    public BookResponseDTO updateBook(@PathVariable String id, @Valid @RequestBody UpdateBookDTO book){
        return new BookResponseDTO(useCase.execute(id, book));
    };
}
