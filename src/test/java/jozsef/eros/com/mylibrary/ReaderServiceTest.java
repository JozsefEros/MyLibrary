package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.model.Reader;
import jozsef.eros.com.mylibrary.repository.ReaderRepository;
import jozsef.eros.com.mylibrary.service.ReaderService;
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

public class ReaderServiceTest {

    @InjectMocks
    private ReaderService readerService;

    @Mock
    private ReaderRepository readerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllReaders() {
        when(readerRepository.findAll()).thenReturn(Collections.emptyList());

        assertEquals(0, readerService.getAllReaders().size());
        verify(readerRepository, times(1)).findAll();
    }

    @Test
    public void testGetReaderById() {
        Reader reader = new Reader();
        reader.setId(1L);
        when(readerRepository.findById(1L)).thenReturn(Optional.of(reader));

        Reader foundReader = readerService.getReaderById(1L);
        assertNotNull(foundReader);
        assertEquals(1L, foundReader.getId());
    }

    @Test
    public void testCreateReader() {
        Reader reader = new Reader();
        when(readerRepository.save(any(Reader.class))).thenReturn(reader);

        Reader createdReader = readerService.createReader(reader);
        assertNotNull(createdReader);
        verify(readerRepository, times(1)).save(reader);
    }

    @Test
    public void testUpdateReader() {
        Reader existingReader = new Reader();
        existingReader.setId(1L);
        when(readerRepository.findById(1L)).thenReturn(Optional.of(existingReader));
        when(readerRepository.save(any(Reader.class))).thenReturn(existingReader);

        Reader updatedReader = readerService.updateReader(1L, existingReader);
        assertNotNull(updatedReader);
        verify(readerRepository, times(1)).findById(1L);
        verify(readerRepository, times(1)).save(existingReader);
    }

    @Test
    public void testDeleteReader() {
        readerService.deleteReader(1L);
        verify(readerRepository, times(1)).deleteById(1L);
    }
}
