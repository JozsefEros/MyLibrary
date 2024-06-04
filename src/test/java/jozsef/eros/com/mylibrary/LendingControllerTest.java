package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.controller.LendingController;
import jozsef.eros.com.mylibrary.model.Catalog;
import jozsef.eros.com.mylibrary.model.Lending;
import jozsef.eros.com.mylibrary.service.CatalogService;
import jozsef.eros.com.mylibrary.service.LendingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LendingController.class)
public class LendingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LendingService lendingService;

    @MockBean
    private CatalogService catalogService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllLendings() throws Exception {
        Lending lending = new Lending();
        List<Lending> lendings = Collections.singletonList(lending);

        when(lendingService.getAllLendings()).thenReturn(lendings);

        mockMvc.perform(get("/lendings")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void testGetLendingById() throws Exception {
        Lending lending = new Lending();
        lending.setId(1L);

        when(lendingService.getLendingById(1L)).thenReturn(lending);

        mockMvc.perform(get("/lendings/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void testGetLendingByIdNotFound() throws Exception {
        when(lendingService.getLendingById(anyLong())).thenReturn(null);

        mockMvc.perform(get("/lendings/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
/*
    @Test
    public void testCreateLending() throws Exception {
        Lending lending = new Lending();
        lending.setId(1L);

        when(lendingService.createLending(any(Lending.class))).thenReturn(lending);

        mockMvc.perform(post("/lendings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"reader\":1,\"book\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void testUpdateLending() throws Exception {
        Lending lending = new Lending();
        lending.setId(1L);

        when(lendingService.updateLending(anyLong(), any(Lending.class))).thenReturn(lending);

        mockMvc.perform(put("/lendings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"reader\":2,\"book\":2}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void testUpdateLendingNotFound() throws Exception {
        when(lendingService.updateLending(anyLong(), any(Lending.class))).thenReturn(null);

        mockMvc.perform(put("/lendings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"reader\":2,\"book\":2}"))
                .andExpect(status().isNotFound());
    }
*/
    @Test
    public void testDeleteLending() throws Exception {
        doNothing().when(lendingService).deleteLending(anyLong());

        mockMvc.perform(delete("/lendings/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(lendingService, times(1)).deleteLending(anyLong());
    }
}
