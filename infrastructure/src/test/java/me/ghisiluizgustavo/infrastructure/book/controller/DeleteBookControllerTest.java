package me.ghisiluizgustavo.infrastructure.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ghisiluizgustavo.domain.ID;
import me.ghisiluizgustavo.domain.book.model.Book;
import me.ghisiluizgustavo.domain.book.model.Isbn;
import me.ghisiluizgustavo.infrastructure.book.dto.BookResponseDTO;
import me.ghisiluizgustavo.infrastructure.book.dto.CreateBookDTO;
import me.ghisiluizgustavo.usecase.book.CreateBookUseCase;
import me.ghisiluizgustavo.usecase.book.DeleteBookUseCase;
import me.ghisiluizgustavo.usecase.book.dto.IBookCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeleteBookController.class)
public class DeleteBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeleteBookUseCase deleteBookUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateBookSuccessfully() throws Exception {
        Mockito.doNothing().when(deleteBookUseCase).execute(anyString());

        ResultActions result = mockMvc.perform(delete("/api/v1/book/{id}", UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNoContent());
    }
}