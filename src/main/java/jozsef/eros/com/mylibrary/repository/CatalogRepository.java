package jozsef.eros.com.mylibrary.repository;

import jozsef.eros.com.mylibrary.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    @Query("SELECT b FROM Catalog b WHERE " +
            "LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Catalog> findByTitleContaining(@Param("title") String title);

    @Query("SELECT a FROM Catalog a WHERE " +
            "LOWER(a.author) LIKE LOWER(CONCAT('%', :author, '%'))")
    List<Catalog> findByAuthorContaining(@Param("author") String author);

}
