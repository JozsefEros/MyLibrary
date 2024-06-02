package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.model.Lending;
import jozsef.eros.com.mylibrary.repository.LendingRepository;
import jozsef.eros.com.mylibrary.service.LendingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LendingServiceTest {

    @Mock
    private LendingRepository lendingRepository;

    @InjectMocks
    private LendingService lendingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllLendings() {
        Lending lending = new Lending();
        when(lendingRepository.findAll()).thenReturn(Collections.singletonList(lending));

        List<Lending> lendings = lendingService.getAllLendings();

        assertNotNull(lendings);
        assertEquals(1, lendings.size());
        verify(lendingRepository, times(1)).findAll();
    }

    @Test
    void testGetLendingById() {
        Long id = 1L;
        Lending lending = new Lending();
        when(lendingRepository.findById(id)).thenReturn(Optional.of(lending));

        Lending foundLending = lendingService.getLendingById(id);

        assertNotNull(foundLending);
        verify(lendingRepository, times(1)).findById(id);
    }

    @Test
    void testCreateLending() {
        Lending lending = new Lending();
        when(lendingRepository.save(lending)).thenReturn(lending);

        Lending createdLending = lendingService.createLending(lending);

        assertNotNull(createdLending);
        verify(lendingRepository, times(1)).save(lending);
    }

    @Test
    void testUpdateLending() {
        Long id = 1L;
        Lending existingLending = new Lending();
        Lending updatedLendingDetails = new Lending();
        when(lendingRepository.findById(id)).thenReturn(Optional.of(existingLending));
        when(lendingRepository.save(existingLending)).thenReturn(existingLending);

        Lending updatedLending = lendingService.updateLending(id, updatedLendingDetails);

        assertNotNull(updatedLending);
        verify(lendingRepository, times(1)).findById(id);
        verify(lendingRepository, times(1)).save(existingLending);
    }

    @Test
    void testDeleteLending() {
        Long id = 1L;
        doNothing().when(lendingRepository).deleteById(id);

        lendingService.deleteLending(id);

        verify(lendingRepository, times(1)).deleteById(id);
    }
}
