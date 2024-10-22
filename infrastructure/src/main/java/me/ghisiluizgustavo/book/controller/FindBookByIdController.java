package me.ghisiluizgustavo.book.controller;

import me.ghisiluizgustavo.book.FindBookByIdUseCase;
import me.ghisiluizgustavo.book.dto.BookResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class FindBookByIdController {

    private final FindBookByIdUseCase useCase;

    @GetMapping("/{id}")
    public BookResponseDTO findById(@PathVariable String id){
        return new BookResponseDTO(useCase.execute(id));
    }
}
