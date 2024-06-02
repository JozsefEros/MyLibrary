package jozsef.eros.com.mylibrary;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jozsef.eros.com.mylibrary.model.Lending;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LendingTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testLendingValidation() {
        Lending lending = new Lending();
        lending.setReader(lending.getReader());
        lending.setBook(lending.getBook());
        lending.setLendingDate(LocalDate.now());

        Set<ConstraintViolation<Lending>> violations = validator.validate(lending);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testReaderIdNotNull() {
        Lending lending = new Lending();
        lending.setReader(null);
        lending.setBook(lending.getBook());
        lending.setLendingDate(LocalDate.now());

        Set<ConstraintViolation<Lending>> violations = validator.validate(lending);
        assertFalse(violations.isEmpty());
        assertEquals("Az olvasó azonosítója nem lehet üres!", violations.iterator().next().getMessage());
    }

    @Test
    public void testBookIdNotNull() {
        Lending lending = new Lending();
        lending.setReader(lending.getReader());
        lending.setBook(null);
        lending.setLendingDate(LocalDate.now());

        Set<ConstraintViolation<Lending>> violations = validator.validate(lending);
        assertFalse(violations.isEmpty());
        assertEquals("A könyv azonosítója nem lehet üres!", violations.iterator().next().getMessage());
    }
}
