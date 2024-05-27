package jozsef.eros.com.mylibrary;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import jozsef.eros.com.mylibrary.model.Reader;
import jozsef.eros.com.mylibrary.service.ReaderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReaderService readerService;

    @Test
    public void testGetAllReaders() throws Exception {
        when(readerService.getAllReaders()).thenReturn(List.of(new Reader(), new Reader()));

        mockMvc.perform(get("/readers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testGetReaderById() throws Exception {
        Long readerId = 1L;
        Reader reader = new Reader();
        reader.setId(readerId);

        when(readerService.getReaderById(readerId)).thenReturn(reader);

        mockMvc.perform(get("/readers/{id}", readerId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(readerId));
    }

    @Test
    public void testCreateReader() throws Exception {
        Reader reader = new Reader();
        reader.setId(1L);
        reader.setFirstName("John");
        reader.setMiddleName("Doe");

        when(readerService.createReader(any(Reader.class))).thenReturn(reader);

        String requestBody = "{\"firstName\":\"John\",\"middleName\":\"Doe\"}";

        mockMvc.perform(post("/readers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.middleName").value("Doe"));
    }

    @Test
    public void testUpdateReader() throws Exception {
        Long readerId = 1L;
        Reader existingReader = new Reader();
        existingReader.setId(readerId);
        existingReader.setFirstName("Jane");

        Reader updatedReader = new Reader();
        updatedReader.setId(readerId);
        updatedReader.setFirstName("John");

        when(readerService.updateReader(eq(readerId), any(Reader.class))).thenReturn(updatedReader);

        String requestBody = "{\"firstName\":\"John\"}";

        mockMvc.perform(put("/readers/{id}", readerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(readerId))
                .andExpect(jsonPath("$.firstName").value("John"));
    }

    @Test
    public void testDeleteReader() throws Exception {
        Long readerId = 1L;

        mockMvc.perform(delete("/readers/{id}", readerId))
                .andExpect(status().isNoContent());

        verify(readerService, times(1)).deleteReader(readerId);
    }
}