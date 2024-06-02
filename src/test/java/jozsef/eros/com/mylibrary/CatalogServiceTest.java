package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.model.Catalog;
import jozsef.eros.com.mylibrary.repository.CatalogRepository;
import jozsef.eros.com.mylibrary.service.CatalogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CatalogServiceTest {

    @InjectMocks
    private CatalogService catalogService;

    @Mock
    private CatalogRepository catalogRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCatalog() {
        when(catalogRepository.findAll()).thenReturn(Collections.emptyList());

        assertEquals(0, catalogService.getAllCatalog().size());
        verify(catalogRepository, times(1)).findAll();
    }

    @Test
    public void testGetCatalogById() {
        Catalog catalog = new Catalog();
        catalog.setId(1);
        when(catalogRepository.findById(1L)).thenReturn(Optional.of(catalog));

        Catalog foundCatalog = catalogService.getCatalogById(1L);
        assertNotNull(foundCatalog);
        assertEquals(1, foundCatalog.getId());
    }

    @Test
    public void testCreateCatalog() {
        Catalog catalog = new Catalog();
        when(catalogRepository.save(any(Catalog.class))).thenReturn(catalog);

        Catalog createdCatalog = catalogService.createCatalog(catalog);
        assertNotNull(createdCatalog);
        verify(catalogRepository, times(1)).save(catalog);
    }

    @Test
    public void testUpdateCatalog() {
        Catalog existingCatalog = new Catalog();
        existingCatalog.setId(1);
        when(catalogRepository.findById(1L)).thenReturn(Optional.of(existingCatalog));
        when(catalogRepository.save(any(Catalog.class))).thenReturn(existingCatalog);

        Catalog updatedCatalog = catalogService.updateCatalog(1L, existingCatalog);
        assertNotNull(updatedCatalog);
        verify(catalogRepository, times(1)).findById(1L);
        verify(catalogRepository, times(1)).save(existingCatalog);
    }

    @Test
    public void testDeleteCatalog() {
        catalogService.deleteCatalog(1L);
        verify(catalogRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindBooksByTitle() {
        when(catalogRepository.findByTitleContaining("Title")).thenReturn(Collections.emptyList());

        assertEquals(0, catalogService.findBooksByTitle("Title").size());
        verify(catalogRepository, times(1)).findByTitleContaining("Title");
    }

    @Test
    public void testFindBooksByAuthor() {
        when(catalogRepository.findByAuthorContaining("Author")).thenReturn(Collections.emptyList());

        assertEquals(0, catalogService.findBooksByAuthor("Author").size());
        verify(catalogRepository, times(1)).findByAuthorContaining("Author");
    }
}
