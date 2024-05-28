package jozsef.eros.com.mylibrary.repository;

import jozsef.eros.com.mylibrary.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending, Long> {
}