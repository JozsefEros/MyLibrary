package jozsef.eros.com.mylibrary.controller;

import jakarta.validation.Valid;
import jozsef.eros.com.mylibrary.model.Catalog;
import jozsef.eros.com.mylibrary.model.Reader;
import jozsef.eros.com.mylibrary.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public List<Catalog> getAllCatalog() {
        return catalogService.getAllCatalog();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getCatalogById(@PathVariable Long id) {
        Catalog catalog = catalogService.getCatalogById(id);
        if (catalog != null) {
            return ResponseEntity.ok(catalog);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Catalog createCatalog(@Valid @RequestBody Catalog catalog) {
        return catalogService.createCatalog(catalog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catalog> updateCatalog(@PathVariable Long id, @Valid @RequestBody Catalog catalogDetails) {
        Catalog updateCatalog = catalogService.updateCatalog(id, catalogDetails);
        if (updateCatalog != null) {
            return ResponseEntity.ok(updateCatalog);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalog(@PathVariable Long id) {
        catalogService.deleteCatalog(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/searchTitles")
    public List<Catalog> findBooksByTitle(@RequestParam String title) {
        return catalogService.findBooksByTitle(title);
    }

    @GetMapping("/searchAuthors")
    public List<Catalog> findBooksByAuthor(@RequestParam String author) {
        return catalogService.findBooksByAuthor(author);
    }
}
