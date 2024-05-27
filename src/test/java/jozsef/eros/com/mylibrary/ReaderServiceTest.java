package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.model.Reader;
import jozsef.eros.com.mylibrary.repository.ReaderRepository;
import jozsef.eros.com.mylibrary.service.ReaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private ReaderService readerService;

    private Reader testReader;

    @BeforeEach
    void setUp() {
        testReader = new Reader();
        testReader.setId(1L);
        testReader.setFirstName("John");
        testReader.setMiddleName("Doe");
        testReader.setLastName("Smith");
        testReader.setYearOfBirth(1985);
        // Other necessary initialization
    }

    @Test
    void testGetReaderById() {
        when(readerRepository.findById(1L)).thenReturn(Optional.of(testReader));
        Reader retrievedReader = readerService.getReaderById(1L);
        assertNotNull(retrievedReader);
        assertEquals("John", retrievedReader.getFirstName());
        assertEquals("Doe", retrievedReader.getMiddleName());
        assertEquals("Smith", retrievedReader.getLastName());
    }
}
