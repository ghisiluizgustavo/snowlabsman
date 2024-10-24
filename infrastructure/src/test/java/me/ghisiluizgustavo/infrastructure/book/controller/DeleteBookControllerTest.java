package me.ghisiluizgustavo.infrastructure.book.controller;

import me.ghisiluizgustavo.usecase.book.DeleteBookUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeleteBookController.class)
public class DeleteBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeleteBookUseCase deleteBookUseCase;

    @Test
    void shouldDeleteBookSuccessfully() throws Exception {
        Mockito.doNothing().when(deleteBookUseCase).execute(anyString());

        ResultActions result = mockMvc.perform(delete("/api/v1/book/{id}", UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNoContent());
    }
}