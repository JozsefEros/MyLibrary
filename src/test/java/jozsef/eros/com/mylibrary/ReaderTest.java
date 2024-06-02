package jozsef.eros.com.mylibrary;

import jozsef.eros.com.mylibrary.model.Reader;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderTest {

    @Test
    public void testReaderGettersAndSetters() {
        Reader reader = new Reader();

        reader.setId(1);
        reader.setFirstName("John");
        reader.setMiddleName("Doe");
        reader.setLastName("Smith");
        reader.setYearOfBirth(1990);
        reader.setRegistrationDate(new Date());
        reader.setCreatedAt(LocalDate.now());
        reader.setModifiedAt(LocalDate.now());

        assertEquals(1, reader.getId());
        assertEquals("John", reader.getFirstName());
        assertEquals("Doe", reader.getMiddleName());
        assertEquals("Smith", reader.getLastName());
        assertEquals(1990, reader.getYearOfBirth());
        assertEquals(new Date(), reader.getRegistrationDate());
        assertEquals(LocalDate.now(), reader.getCreatedAt());
        assertEquals(LocalDate.now(), reader.getModifiedAt());
    }
}

