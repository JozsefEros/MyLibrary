package jozsef.eros.com.mylibrary;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jozsef.eros.com.mylibrary.model.Catalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidCatalog() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Valid Title");
        catalog.setAuthor("Valid Author");
        catalog.setPublished(LocalDate.now().getYear());

        Set<ConstraintViolation<Catalog>> violations = validator.validate(catalog);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testTitleNotBlank() {
        Catalog catalog = new Catalog();
        catalog.setTitle("");
        catalog.setAuthor("Valid Author");
        catalog.setPublished(LocalDate.now().getYear());

        Set<ConstraintViolation<Catalog>> violations = validator.validate(catalog);
        assertEquals(1, violations.size());
        assertEquals("A könyv címe nem lehet üres!", violations.iterator().next().getMessage());
    }

    @Test
    public void testAuthorNotBlank() {
        Catalog catalog = new Catalog();
        catalog.setTitle("Valid Title");
        catalog.setAuthor("");
        catalog.setPublished(LocalDate.now().getYear());

        Set<ConstraintViolation<Catalog>> violations = validator.validate(catalog);
        assertEquals(1, violations.size());
        assertEquals("A szerző nem lehet üres!", violations.iterator().next().getMessage());
    }

}

