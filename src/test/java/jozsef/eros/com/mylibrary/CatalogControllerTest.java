package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.controller.CatalogController;
import jozsef.eros.com.mylibrary.model.Catalog;
import jozsef.eros.com.mylibrary.service.CatalogService;
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

@WebMvcTest(CatalogController.class)
public class CatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CatalogService catalogService;

    @Test
    public void testGetAllCatalog() throws Exception {
        Mockito.when(catalogService.getAllCatalog()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/catalog")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetCatalogById() throws Exception {
        Catalog catalog = new Catalog();
        catalog.setId(1);
        Mockito.when(catalogService.getCatalogById(1L)).thenReturn(catalog);

        mockMvc.perform(MockMvcRequestBuilders.get("/catalog/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1}"));
    }

    @Test
    public void testCreateCatalog() throws Exception {
        Catalog catalog = new Catalog();
        Mockito.when(catalogService.createCatalog(Mockito.any(Catalog.class))).thenReturn(catalog);

        mockMvc.perform(MockMvcRequestBuilders.post("/catalog")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Title\", \"author\": \"Author\", \"genre\": \"Genre\", \"published\": \"2023\", \"publisher\": \"Publisher\", \"language\": \"Language\", \"available\": true}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCatalog() throws Exception {
        Catalog catalog = new Catalog();
        catalog.setId(1);
        Mockito.when(catalogService.updateCatalog(Mockito.eq(1L), Mockito.any(Catalog.class))).thenReturn(catalog);

        mockMvc.perform(MockMvcRequestBuilders.put("/catalog/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Updated Title\", \"author\": \"Updated Author\", \"genre\": \"Updated Genre\", \"published\": \"2023\", \"publisher\": \"Updated Publisher\", \"language\": \"Updated Language\", \"available\": false}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCatalog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/catalog/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testFindBooksByTitle() throws Exception {
        Mockito.when(catalogService.findBooksByTitle("Title")).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/catalog/searchTitles")
                        .param("title", "Title")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testFindBooksByAuthor() throws Exception {
        Mockito.when(catalogService.findBooksByAuthor("Author")).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/catalog/searchAuthors")
                        .param("author", "Author")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
