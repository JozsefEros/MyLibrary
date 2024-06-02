package jozsef.eros.com.mylibrary;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import jozsef.eros.com.mylibrary.model.Lending;
import jozsef.eros.com.mylibrary.repository.LendingRepository;
import jozsef.eros.com.mylibrary.service.LendingService;

@SpringBootTest
public class LendingServiceTest {
/*
    @Autowired
    private LendingService lendingService;

    @Autowired
    private LendingRepository lendingRepository;

    @Test
    public void testGetAllLendings() {

        when(lendingRepository.findAll()).thenReturn(List.of(new Lending(), new Lending()));

        List<Lending> lendings = lendingService.getAllLendings();

        assertEquals(2, lendings.size());
    }

 */
}

