package jozsef.eros.com.mylibrary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.time.LocalDate;
import java.util.Set;
import jozsef.eros.com.mylibrary.model.Lending;

public class LendingTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testLendingValidation() {
        Lending lending = new Lending();
        lending.setReader(123); // Példa érték
        lending.setBook(456); // Példa érték
        lending.setLendingDate(LocalDate.now());

        Set<ConstraintViolation<Lending>> violations = validator.validate(lending);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testReaderIdNotNull() {
        Lending lending = new Lending();
        lending.setReader(null);
        lending.setBook(456);
        lending.setLendingDate(LocalDate.now());

        Set<ConstraintViolation<Lending>> violations = validator.validate(lending);
        assertFalse(violations.isEmpty());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    @Test
    public void testBookIdNotNull() {
        Lending lending = new Lending();
        lending.setReader(22);
        lending.setBook(null);
        lending.setLendingDate(LocalDate.now());

        Set<ConstraintViolation<Lending>> violations = validator.validate(lending);
        assertFalse(violations.isEmpty());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }
}
