package jozsef.eros.com.springtest.repository;

import jozsef.eros.com.springtest.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}