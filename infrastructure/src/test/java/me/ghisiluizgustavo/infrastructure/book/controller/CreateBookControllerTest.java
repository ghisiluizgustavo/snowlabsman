package me.ghisiluizgustavo.infrastructure.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ghisiluizgustavo.domain.ID;
import me.ghisiluizgustavo.infrastructure.book.db.repository.BookRepository;
import me.ghisiluizgustavo.infrastructure.customer.db.repository.CustomerRepository;
import me.ghisiluizgustavo.usecase.book.CreateBookUseCase;
import me.ghisiluizgustavo.usecase.book.dto.IBookCreate;
import me.ghisiluizgustavo.domain.book.model.Book;
import me.ghisiluizgustavo.domain.book.model.Isbn;
import me.ghisiluizgustavo.infrastructure.book.controller.CreateBookController;
import me.ghisiluizgustavo.infrastructure.book.dto.BookResponseDTO;
import me.ghisiluizgustavo.infrastructure.book.dto.CreateBookDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreateBookController.class)
public class CreateBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateBookUseCase createBookUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    private CreateBookDTO createBookDTO;

    private CreateBookDTO createInvalidBookDTO;

    @BeforeEach
    void setUp() {
        // Configura os dados de teste
        createBookDTO = new CreateBookDTO(
                "978123123",
                "Clean Code",
                "Uncle Bob"
        );

        createInvalidBookDTO = new CreateBookDTO(
                null,
                null,
                null
        );
    }

    @Test
    void shouldCreateBookSuccessfully() throws Exception {
        Book book = new Book(
                new ID("12312123123"),
                new Isbn("978123123"),
                "Clean Code",
                "Uncle Bob",
                true
        );

        Mockito.when(createBookUseCase.execute(any(IBookCreate.class))).thenReturn(book);

        ResultActions result = mockMvc.perform(post("/api/v1/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createBookDTO)));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(new BookResponseDTO(book))));
    }

    @Test
    void shouldReturnBadRequestWhenInvalidInput() throws Exception {
        ResultActions result = mockMvc.perform(post("/api/v1/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createInvalidBookDTO)));

        result.andExpect(status().isBadRequest());
    }
}