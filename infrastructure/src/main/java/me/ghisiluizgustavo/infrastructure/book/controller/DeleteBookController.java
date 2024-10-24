package me.ghisiluizgustavo.infrastructure.book.controller;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.usecase.book.DeleteBookUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class DeleteBookController {

    private final DeleteBookUseCase useCase;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        useCase.execute(id);
    }

}
