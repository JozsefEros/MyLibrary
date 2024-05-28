package jozsef.eros.com.mylibrary.repository;

import jozsef.eros.com.mylibrary.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long>{
}
