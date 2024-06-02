package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.controller.ReaderController;
import jozsef.eros.com.mylibrary.model.Reader;
import jozsef.eros.com.mylibrary.service.ReaderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReaderController.class)
public class ReaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReaderService readerService;

    @Test
    public void testGetAllReaders() throws Exception {
        Mockito.when(readerService.getAllReaders()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/readers")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetReaderById() throws Exception {
        Reader reader = new Reader();
        reader.setId(1);
        Mockito.when(readerService.getReaderById(1L)).thenReturn(reader);

        mockMvc.perform(MockMvcRequestBuilders.get("/readers/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1}"));
    }

    @Test
    public void testCreateReader() throws Exception {
        Reader reader = new Reader();
        Mockito.when(readerService.createReader(Mockito.any(Reader.class))).thenReturn(reader);

        mockMvc.perform(MockMvcRequestBuilders.post("/readers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\": \"John\", \"middleName\": \"Doe\", \"lastName\": \"Smith\", \"yearOfBirth\": 1990, \"registrationDate\": \"2023-01-01\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateReader() throws Exception {
        Reader reader = new Reader();
        reader.setId(1);
        Mockito.when(readerService.updateReader(Mockito.eq(1L), Mockito.any(Reader.class))).thenReturn(reader);

        mockMvc.perform(MockMvcRequestBuilders.put("/readers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\": \"John\", \"middleName\": \"Doe\", \"lastName\": \"Smith\", \"yearOfBirth\": 1990, \"registrationDate\": \"2023-01-01\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteReader() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/readers/1"))
                .andExpect(status().isNoContent());
    }
}
