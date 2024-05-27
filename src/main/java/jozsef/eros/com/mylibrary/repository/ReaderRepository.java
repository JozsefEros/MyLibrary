package jozsef.eros.com.mylibrary.repository;

import jozsef.eros.com.mylibrary.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}