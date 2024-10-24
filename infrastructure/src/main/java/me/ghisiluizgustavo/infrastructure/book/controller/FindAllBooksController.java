package me.ghisiluizgustavo.infrastructure.book.controller;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.usecase.book.FindAllBooksUseCase;
import me.ghisiluizgustavo.infrastructure.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class FindAllBooksController {

    private final FindAllBooksUseCase useCase;

    @GetMapping
    public Page<BookResponseDTO> findAll(Pageable pageable){
        return useCase.execute(pageable).map(BookResponseDTO::new);
    }

}
