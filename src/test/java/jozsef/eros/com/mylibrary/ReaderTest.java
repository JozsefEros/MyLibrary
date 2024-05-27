package jozsef.eros.com.mylibrary;

import static org.junit.Assert.*;

import jozsef.eros.com.mylibrary.model.Reader;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class ReaderTest {

    @Test
    public void testEmptyConstructor() {
        Reader reader = new Reader();
        assertNotNull(reader);
        assertNull(reader.getFirstName());
        assertNull(reader.getMiddleName());
        assertNull(reader.getLastName());
        assertEquals(0, reader.getYearOfBirth());
        assertNull(reader.getRegistrationDate());
        assertNull(reader.getCreatedAt());
        assertNull(reader.getModifiedAt());
    }

    @Test
    public void testValidData() {
        Reader reader = new Reader();
        reader.setFirstName("John");
        reader.setMiddleName("Doe");
        reader.setLastName("Smith");
        reader.setYearOfBirth(1990);

        assertEquals("John", reader.getFirstName());
        assertEquals("Doe", reader.getMiddleName());
        assertEquals("Smith", reader.getLastName());
        assertEquals(1990, reader.getYearOfBirth());
    }

    @Test
    public void testYearOfBirthValidation() {
        // Érvényes születési év beállítása
        int validYearOfBirth = 1990;

        // Érvénytelen születési év beállítása: kisebb, mint 1924
        int invalidYearOfBirth = 1923;

        // Érvénytelen születési év beállítása: nagyobb, mint a jelenlegi év
        int futureYearOfBirth = LocalDate.now().getYear() + 1;

        // Érvénytelen születési év beállítása: negatív érték
        int negativeYearOfBirth = -2000;

        // Tesztelés az érvényes születési évvel
        Reader reader1 = new Reader();
        reader1.setYearOfBirth(validYearOfBirth);
        assertEquals(validYearOfBirth, reader1.getYearOfBirth());

        // Tesztelés az érvénytelen, kisebb értékkel
        Reader reader2 = new Reader();
        reader2.setYearOfBirth(invalidYearOfBirth);
        assertEquals(1924, reader2.getYearOfBirth());

        // Tesztelés az érvénytelen, nagyobb értékkel
        Reader reader3 = new Reader();
        reader3.setYearOfBirth(futureYearOfBirth);
        assertEquals(futureYearOfBirth, reader3.getYearOfBirth());

        // Tesztelés az érvénytelen, negatív értékkel
        Reader reader4 = new Reader();
        reader4.setYearOfBirth(negativeYearOfBirth);
        assertEquals(1924, reader4.getYearOfBirth());
    }

    @Test
    public void testGettersAndSetters() {
        // Tesztadatok inicializálása
        String firstName = "John";
        String middleName = "Doe";
        String lastName = "Smith";
        int yearOfBirth = 1990;
        Date registrationDate = new Date();
        LocalDate createdAt = LocalDate.now();
        LocalDate modifiedAt = LocalDate.now();

        // Reader objektum létrehozása
        Reader reader = new Reader();

        // Setterek használata
        reader.setFirstName(firstName);
        reader.setMiddleName(middleName);
        reader.setLastName(lastName);
        reader.setYearOfBirth(yearOfBirth);
        reader.setRegistrationDate(registrationDate);
        reader.setCreatedAt(createdAt);
        reader.setModifiedAt(modifiedAt);

        // Getterek használata és érték ellenőrzése
        assertEquals(firstName, reader.getFirstName());
        assertEquals(middleName, reader.getMiddleName());
        assertEquals(lastName, reader.getLastName());
        assertEquals(yearOfBirth, reader.getYearOfBirth());
        assertEquals(registrationDate, reader.getRegistrationDate());
        assertEquals(createdAt, reader.getCreatedAt());
        assertEquals(modifiedAt, reader.getModifiedAt());
    }
}

