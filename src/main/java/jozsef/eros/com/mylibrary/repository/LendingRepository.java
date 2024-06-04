package jozsef.eros.com.mylibrary.repository;

import jozsef.eros.com.mylibrary.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LendingRepository extends JpaRepository<Lending, Long> {

    List<Lending> findByReaderId(Long readerId);
}