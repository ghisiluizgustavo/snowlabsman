package me.ghisiluizgustavo.infrastructure.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ghisiluizgustavo.domain.book.exception.BookNotFoundException;
import me.ghisiluizgustavo.domain.book.gateway.BookPersistenceGateway;
import me.ghisiluizgustavo.infrastructure.book.db.repository.BookRepository;
import me.ghisiluizgustavo.infrastructure.config.ErrorResponse;
import me.ghisiluizgustavo.usecase.book.FindBookByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FindBookByIdController.class)
public class FindBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindBookByIdUseCase useCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnExceptionWhenBookNotExist() throws Exception {
        final var bookId = UUID.randomUUID();
        final var errorMessage = "Book with id: " + bookId + " was not found";
        Mockito.when(useCase.execute(bookId.toString()))
                .thenThrow(new BookNotFoundException("Book with id: " + bookId + " was not found"));

        ResultActions result = mockMvc.perform(get("/api/v1/book/{id}", bookId)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound())
                .andExpect(content().json(objectMapper.writeValueAsString(
                        new ErrorResponse(errorMessage, HttpStatus.NOT_FOUND.value())
                )));
    }
}