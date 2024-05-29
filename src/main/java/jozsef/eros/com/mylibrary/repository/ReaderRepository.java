package jozsef.eros.com.mylibrary.repository;

import jozsef.eros.com.mylibrary.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    @Query("SELECT r FROM Reader r WHERE " +
            "LOWER(r.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR " +
            "LOWER(r.middleName) LIKE LOWER(CONCAT('%', :name, '%')) OR " +
            "LOWER(r.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Reader> findByNameContaining(@Param("name") String name);
}